package tool.openjdk_jol;

import org.openjdk.jol.info.ClassLayout;

public class dome {

	public static void main(String[] args) {
		System.out.println("-----------dome.class----------");
		ClassLayout classLayout = ClassLayout.parseInstance(dome.class);
		System.out.println(classLayout.toPrintable());
		System.out.println("---------------------");

		System.out.println("-----------new dome()----------");
		ClassLayout classLayout1 = ClassLayout.parseInstance(new dome());
		System.out.println(classLayout1.toPrintable());
		System.out.println("---------------------");
	}

}
