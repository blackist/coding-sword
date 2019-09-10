package company.bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 输出键值对
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/10
 */
public class Main3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line0 = br.readLine().trim().split(" ");
		String pairDelimiter = line0[0];
		String delimiter = line0[1];
		String pairString = line0[2];

		String[] pairs = pairString.split(pairDelimiter);
		System.out.println(pairs.length);
		for (String pair : pairs) {
			String[] _pair = pair.split(delimiter);
			System.out.println(_pair[0] + " " + _pair[1]);
		}
	}

	private static void func() {

	}
}
