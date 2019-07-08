package jvm.loader;

public class JvmDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("董亮亮的开发笔记");
		Class clazz = Class.forName("java.lang.String");
		System.out.println(clazz.getClassLoader());
		Class clazz1 = Class.forName("jvm.loader.JvmDemo");
		System.out.println(clazz1.getClassLoader());
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
	}
}
