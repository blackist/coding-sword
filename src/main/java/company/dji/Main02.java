package company.dji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO Game
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/6
 */
public class Main02 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lines;
		while ((lines = br.readLine()) != null && !lines.isEmpty()) {
			String[] line = lines.trim().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);
			Map<String, String> control = new HashMap<>();
			for (int i = 0; i < N; ++i) {
				String[] lineI = br.readLine().trim().split(" ");
				control.put(lineI[0], lineI[1]);
			}
			for (int i = 0; i < M; ++i) {
				String cmd = br.readLine().trim();
				System.out.println(control.get(cmd));
			}
		}
	}

}
