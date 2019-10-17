package company.tencent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * TODO 排序
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/17
 */
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line0 = br.readLine().trim().replace("[", "").replace("]","").split(",");
		int[] n = new int[line0.length];
		for (int i = 0; i < line0.length; i++) {
			n[i] = Integer.parseInt(line0[i].trim());
		}
		Arrays.sort(n);
		System.out.println(Arrays.toString(n));
	}
}
