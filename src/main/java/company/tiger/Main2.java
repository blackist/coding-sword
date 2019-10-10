package company.tiger;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 罗马数字
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/8
 */
public class Main2 {

	public static int romanToInt(String s) {
		//罗马符号数字映射表
		Map<Character, Integer> romeNum = new HashMap<Character, Integer>() {{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}};
		//特殊情况映射字符，便于扩展
		Map<Character, Character> special = new HashMap<Character, Character>() {{
			put('V', 'I');
			put('X', 'I');
			put('L', 'X');
			put('C', 'X');
			put('D', 'C');
			put('M', 'C');
		}};
		int sum = 0;
		//通过映射表求和
		for (int i = 0; i <= (s.length() - 1); i++) {
			char c = s.charAt(i);
			if (!romeNum.containsKey(c)) continue;

			sum = sum + romeNum.get(c);
			if (i == 0) continue;
			//处理特殊情况
			if (special.containsKey(c)) {
				char val = special.get(c);
				if (s.charAt(i - 1) == val) {
					sum = sum - romeNum.get(val) * 2;
				}
			}
		}
		//处理上限和下限
		if (sum < 1) return 1;
		if (sum > 3999) return 3999;
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}
