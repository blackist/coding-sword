package org.blackist.jvm.loader;

public class JvmDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("董亮亮的开发笔记");
		Class clazz = Class.forName("java.lang.String");
		System.out.println(clazz.getClassLoader());
		Class clazz1 = Class.forName("org.blackist.jvm.loader.JvmDemo");
		ClassLoader loader1 = clazz1.getClassLoader();
		System.out.println(loader1);
		System.out.println(JvmDemo.class.getClassLoader());
		System.out.println(JvmDemo.class.getClassLoader().getParent());
		System.out.println(JvmDemo.class.getClassLoader().getParent().getParent());
	}
}
