package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 4
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/3
 */
public class Main4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int n = Integer.parseInt(line[0]);
		int q = Integer.parseInt(line[1]);
		int[] arr = new int[200000];
		String[] line1 = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			int j = Integer.parseInt(line1[i]);
			arr[j]++;
		}
		for (int i = 0; i < q; ++i) {
			int qa = Integer.parseInt(br.readLine().trim());
			int count = 0;
			for (int j = qa - 1; j < 200000; j++) {
				if (arr[qa - 1] <= 0) continue;
				if (qa > 1) {
					arr[qa - 2]++;
				}
				arr[qa - 1]--;
				count++;
			}
			System.out.println(count);

		}
	}
}
