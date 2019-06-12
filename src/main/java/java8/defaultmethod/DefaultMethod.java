package java8.defaultmethod;

/**
 * TODO 籍人口中的默认方法
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/12
 */
public class DefaultMethod implements Vihicle, FourWheeler {

	public static void main(String[] args) {
		new DefaultMethod().go();
		FourWheeler.repair();
	}
}


