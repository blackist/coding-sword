package company.qiniu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 查找元素位置
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/17
 */
public class Main3 {

	public static void main() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int m = Integer.parseInt(line0);

		Map<String, String> map = new HashMap<>();
		String[] line1 = br.readLine().trim().split(" ");
		for (int i = 0; i < m; i++) {
			if (!map.containsKey(line1[i])) {
				map.put(line1[i], i + " ");
			} else {
				String s = map.get(line1[i]);
				if (s.endsWith(" "))
					map.put(line1[i], s + i);
				else {
					String s0 = s.substring(0, s.indexOf(" "));
					map.put(line1[i], s0 + " " + i);
				}
			}
		}
		String line2 = br.readLine().trim();
		if (map.containsKey(line2)) {
			if (map.get(line2).endsWith(" "))
				System.out.println("0 0");
			else
				System.out.println(map.get(line2));
		} else {
			System.out.println("-1 -1");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line0 = br.readLine().trim();
		int m = Integer.parseInt(line0);

		int[] arr = new int[m];
		String[] line1 = br.readLine().trim().split(" ");
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(line1[i]);
		}
		int target = Integer.parseInt(br.readLine().trim());
		int[] res = new int[]{-1, -1};
		for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
			if (res[0] == -1 && arr[i] == target) {
				res[0] = i;
			}
			if (res[1] == -1 && arr[j] == target) {
				res[1] = j;
			}
			if (res[0] != -1 && res[1] != -1) {
				break;
			}
		}
		if (res[0] != -1 && res[1] != -1) {
			System.out.println(res[0] + " " + res[1]);
		} else if (res[0] != -1 || res[1]!= -1) {
			System.out.println("0 0");
		} else {
			System.out.println("-1 -1");
		}
	}
}
