package read_source.锁.synchronized详解;

import org.openjdk.jol.info.ClassLayout;
/**
 * 64位对象头由Mark Word、klass pointer(指向类的指针)两部分组成，如果对象是数组，则还要加上数组长度，即三部分组成。

Mark Word由64位8个字节组成。

klass pointer由64位8个字节组成，但我们使用的64位 JVM会默认使用选项 +UseCompressedOops 开启指针压缩，将指针压缩至32位。即上面截图中的klass pointer为4个字节32位。

类指针klass pointer和数组长度，很简单这里不在描述，重点描述下Mark Word部分。

Mark Word的64位，不同的位表示的意思不一样，具体如下所示：


|--------------------------------------------------------------------------------------------------------------|
|                                              Object Header (128 bits)                                        |
|--------------------------------------------------------------------------------------------------------------|
|                        Mark Word (64 bits)                                    |      Klass Word (64 bits)    |       
|--------------------------------------------------------------------------------------------------------------|
|  unused:25 | identity_hashcode:31 | unused:1 | age:4 | biased_lock:1 | lock:2 |     OOP to metadata object   |  无锁
|----------------------------------------------------------------------|--------|------------------------------|
|  thread:54 |         epoch:2      | unused:1 | age:4 | biased_lock:1 | lock:2 |     OOP to metadata object   |  偏向锁
|----------------------------------------------------------------------|--------|------------------------------|
|                     ptr_to_lock_record:62                            | lock:2 |     OOP to metadata object   |  轻量锁
|----------------------------------------------------------------------|--------|------------------------------|
|                     ptr_to_heavyweight_monitor:62                    | lock:2 |     OOP to metadata object   |  重量锁
|----------------------------------------------------------------------|--------|------------------------------|
|                                                                      | lock:2 |     OOP to metadata object   |    GC
|--------------------------------------------------------------------------------------------------------------|
 
 lock:  锁状态标记位，该标记的值不同，整个mark word表示的含义不同。

biased_lock：偏向锁标记，为1时表示对象启用偏向锁，为0时表示对象没有偏向锁。
|-----------------------------------|
|   biased_lock | lock     |  状态        |
|-----------------------------------|
|   0           |   01     | 无锁          | 
|-----------------------------------|
|   1           |   01     | 偏向锁      | 
|-----------------------------------|
|   0           |   00     | 轻量级锁   | 
|-----------------------------------|
|   0           |   10     | 重量级锁  | 
|-----------------------------------|
|   0           |   11     | GC标记     | 
|-----------------------------------|

age：Java GC标记位对象年龄，4位的表示范围为0-15，因此对象经过了15次垃圾回收后如果还存在，则肯定会移动到老年代中。

identity_hashcode：对象标识Hash码，采用延迟加载技术。当对象使用HashCode()计算后，并会将结果写到该对象头中。当对象被锁定时，该值会移动到线程Monitor中。

thread：持有偏向锁的线程ID和其他信息。这个线程ID并不是JVM分配的线程ID号，和Java Thread中的ID是两个概念。

epoch：偏向时间戳。

ptr_to_lock_record：指向栈中锁记录的指针。

ptr_to_heavyweight_monitor：指向线程Monitor的指针。


JDK1.6以后的版本在处理同步锁时存在锁升级的概念，JVM对于同步锁的处理是从偏向锁开始的，随着竞争越来越激烈，处理方式从偏向锁升级到轻量级锁，最终升级到重量级锁。

现在我们应该知道，Synchronized是通过对象内部的一个叫做监视器锁（monitor）来实现的。但是监视器锁本质又是依赖于底层的操作系统的Mutex Lock来实现的。
而操作系统实现线程之间的切换这就需要从用户态转换到核心态，这个成本非常高，状态之间的转换需要相对比较长的时间，这就是为什么Synchronized效率低的原因。
因此，这种依赖于操作系统Mutex Lock所实现的锁我们称之为“重量级锁”。JDK中对Synchronized做的种种优化，其核心都是为了减少这种重量级锁的使用。
JDK1.6以后，为了减少获得锁和释放锁所带来的性能消耗，提高性能，引入了“轻量级锁”和“偏向锁”。

JVM一般是这样使用锁和Mark Word的：

1，当没有被当成锁时，这就是一个普通的对象，Mark Word记录对象的HashCode，锁标志位是01，是否偏向锁那一位是0。

2，当对象被当做同步锁并有一个线程A抢到了锁时，锁标志位还是01，但是否偏向锁那一位改成1，前23bit记录抢到锁的线程id，表示进入偏向锁状态。

3，当线程A再次试图来获得锁时，JVM发现同步锁对象的标志位是01，是否偏向锁是1，也就是偏向状态，Mark Word中记录的线程id就是线程A自己的id，表示线程A已经获得了这个偏向锁，可以执行同步锁的代码。

4，当线程B试图获得这个锁时，JVM发现同步锁处于偏向状态，但是Mark Word中的线程id记录的不是B，那么线程B会先用CAS操作试图获得锁，这里的获得锁操作是有可能成功的，因为线程A一般不会自动释放偏向锁。如果抢锁成功，就把Mark Word里的线程id改为线程B的id，代表线程B获得了这个偏向锁，可以执行同步锁代码。如果抢锁失败，则继续执行步骤5。

5，偏向锁状态抢锁失败，代表当前锁有一定的竞争，偏向锁将升级为轻量级锁。JVM会在当前线程的线程栈中开辟一块单独的空间，里面保存指向对象锁Mark Word的指针，同时在对象锁Mark Word中保存指向这片空间的指针。上述两个保存操作都是CAS操作，如果保存成功，代表线程抢到了同步锁，就把Mark Word中的锁标志位改成00，可以执行同步锁代码。如果保存失败，表示抢锁失败，竞争太激烈，继续执行步骤6。

6，轻量级锁抢锁失败，JVM会使用自旋锁，自旋锁不是一个锁状态，只是代表不断的重试，尝试抢锁。从JDK1.7开始，自旋锁默认启用，自旋次数由JVM决定。如果抢锁成功则执行同步锁代码，如果失败则继续执行步骤7。

7，自旋锁重试之后如果抢锁依然失败，同步锁会升级至重量级锁，锁标志位改为10。在这个状态下，未抢到锁的线程都会被阻塞。
 * 
 * @author user
 *
 */
public  class dome {

	public static void main(String[] args) {
		System.out.println("***********dome.class**********");
		ClassLayout classLayout = ClassLayout.parseInstance(dome.class);
//		System.out.print(classLayout.toPrintable());
		System.out.println("***********dome.class**********");
		 
		System.out.println("***********new dome()**********");
		dome d = new dome();
//		d.hashCode();
		ClassLayout classLayout1 = ClassLayout.parseInstance(d);
		System.out.print(classLayout1.toPrintable());
		synchronized (d) {
			ClassLayout classLayout3 = ClassLayout.parseInstance(d);
			System.out.print(classLayout3.toPrintable());
			System.out.println("ddd");
		}
		System.out.println("***********new dome()**********");
		
		System.out.println("***********new dome[10]**********");
		ClassLayout classLayout2 = ClassLayout.parseInstance(new dome[10]);
//		System.out.print(classLayout2.toPrintable());
		System.out.println("***********new dome[10]**********");
	}

}
