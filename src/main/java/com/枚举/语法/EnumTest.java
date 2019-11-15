package com.枚举.语法;
public enum EnumTest {
    MON, TUE, WED, THU, FRI, SAT, SUN;
	/*这段代码实际上调用了7次 Enum(String name, int ordinal)：

	new Enum<EnumTest>("MON",0);
	new Enum<EnumTest>("TUE",1);
	new Enum<EnumTest>("WED",2);
	    ... ...*/
	
	
	
	public static void main(String[] args) {
        for (EnumTest e : EnumTest.values()) {
            System.out.println(e.ordinal()+"-->"+e.toString());
        }
         
        System.out.println("----------------我是分隔线------------------");
         
        EnumTest test = EnumTest.TUE;
        switch (test) {
        case MON:
            System.out.println("今天是星期一");
            break;
        case TUE:
            System.out.println("今天是星期二");
            break;
        // ... ...
        default:
            System.out.println(test);
            break;
        }
    }
}
