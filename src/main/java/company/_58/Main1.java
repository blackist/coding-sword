package company._58;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 统计数字
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/12
 */
public class Main1 {


	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] line0 = br.readLine().trim().split(",");

		Map<String, String> counter = new HashMap<>();
		for (String s : line0) {
			counter.put(s, null);
		}
		System.out.println(counter.size());
	}
}
