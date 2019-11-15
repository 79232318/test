package com.设计原则.里氏替换原则;

public class Test {
    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth()<=rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth()+1);
            System.out.println("width:"+rectangle.getWidth()+" length:"+rectangle.getLength());
        }
        System.out.println("方法结束：width:"+rectangle.getWidth()+" length:"+rectangle.getLength());
    }

    public static void main(String[] args){
//        Rectangle rectangle = new Rectangle();
//        rectangle.setWidth(10);
//        rectangle.setLength(20);
//        resize(rectangle);
    	
    	/*注意测试的是 长方形的实例
    	如果换成了正方形 那么这个程序将会永久的执行下去 直到溢出
    	不符合 里氏替换原则*/
//    	Square s = new Square();
//    	s.setWidth(10);
//    	s.setLength(20);
//    	resize(s);
    }
}
