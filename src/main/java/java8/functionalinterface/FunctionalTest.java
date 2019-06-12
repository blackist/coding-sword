package java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * TODO 函数式接口测试
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/12
 */
public class FunctionalTest {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		eval(list, n -> true);

		eval(list, n -> n % 3 == 0);
	}

	private static void eval(List<Integer> list, Predicate<Integer> predicate) {
		list.stream()
				.filter(predicate)
				.forEach(System.out::print);
		System.out.println("");
	}
}
