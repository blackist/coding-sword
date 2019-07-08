package jvm.loader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO 自定义类加载器
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/7/6
 */
public class BLoader extends ClassLoader {

	private String name;

	private String path = "D:\\"; // 加载类的路径

	private final String fileType = ".class"; // class文件扩展名

	public BLoader(String name) {
		super(); // 让系统类加载器成为该类加载器的父加载器
		this.name = name;
	}

	public BLoader(ClassLoader parent, String name) {
		super(parent); // 显式指定父类加载器
		this.name = name;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = loadClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}

	private byte[] loadClassData(String name) {
		byte[] data = null;
		try (
				InputStream is = new FileInputStream(new File(path+name+fileType));
			 	ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			int ch = 0;
			while (-1 != (ch = is.read())) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// 环境变量有的话 从AppClassLoader加载; ExtClassLoader从jre/lib/ext 加载; Bootstrap从
		BLoader loader1 = new BLoader("loader1");
		loader1.setPath("D:\\Cache\\loader\\client\\");
		BLoader loader2 = new BLoader(loader1, "loader2");
		loader2.setPath("D:\\Cache\\loader\\server\\");
		BLoader loader3 = new BLoader(null, "loader3");
		loader3.setPath("D:\\Cache\\loader\\other\\");

		testLoader(loader2);
		testLoader(loader3);

		Class clazz = loader1.loadClass("Sample");
		System.out.println(clazz.hashCode());
		Object object = clazz.newInstance();

		loader1 = null;
		clazz = null;
		object = null;

		loader1 = new BLoader("loader1");
		loader1.setPath("D:\\Cache\\loader\\client\\");
		clazz = loader1.loadClass("Sample");
		System.out.println(clazz.hashCode());
	}

	private static void testLoader(BLoader loader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class clazz = loader.loadClass("jvm.loader.Sample");
		Object object = clazz.newInstance();
	}
}
