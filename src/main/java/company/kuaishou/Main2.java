package company.kuaishou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * TODO 拨号键
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/16
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		char[] nums = line0.toCharArray();
		List<Character[]> nl = new ArrayList<>();
		for (char num : nums) {
			switch (num) {
				case '2': {
					nl.add(new Character[]{'a', 'b', 'c'});
				}
				break;
				case '3': {
					nl.add(new Character[]{'d', 'e', 'f'});
				}
				break;
				case '4': {
					nl.add(new Character[]{'g', 'h', 'i'});
				}
				break;
				case '5': {
					nl.add(new Character[]{'j', 'k', 'l'});
				}
				break;
				case '6': {
					nl.add(new Character[]{'m', 'n', 'o'});
				}
				break;
				case '7': {
					nl.add(new Character[]{'p', 'q', 'r', 's'});
				}
				break;
				case '8': {
					nl.add(new Character[]{'t', 'u', 'v'});
				}
				break;
				case '9': {
					nl.add(new Character[]{'w', 'x', 'y', 'z'});
				}
				break;

			}
		}

		func(nl, "");
		System.out.println(res);
	}

	private static List<String> res = new ArrayList<>();

	private static String func(List<Character[]> nl, String s) {

		if (nl.size() == 0) {
			s += ", ";
			res.add(s);
			return s;
		}

		Character[] cs = nl.get(0);
		nl.remove(0);

		StringBuilder s1 = new StringBuilder(s);
		for (char c : cs) {
			s1.append(c);
			func(nl, s);
		}
		return null;
	}
}
