package company.dji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * TODO Game
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/6
 */
public class Main01 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		int T = Integer.parseInt(line);
		for (int i = 0; i < T; ++i) {
			String[] lineI = br.readLine().trim().split(" ");
			int N = Integer.parseInt(lineI[0]);
			int X = Integer.parseInt(lineI[1]);

			int[] games = new int[N];
			int[] costs = new int[N];
			int game = 0;
			int cost = 0;
			for (int j = 0; j < N; ++j) {
				String[] lineJ = br.readLine().trim().split(" ");
				games[j] = Integer.parseInt(lineJ[0]);
				costs[j] = Integer.parseInt(lineJ[1]);
				game += games[j];
				cost += costs[j];
			}
			gain(games, costs, X, game / cost);
		}
	}

	private static void gain(int[] games, int[] costs, int X, int avg) {

		List<Integer> high = new ArrayList<>();
		List<Integer> low = new ArrayList<>();
		for (int i = 0; i < games.length; ++i) {
			int temp = games[i] / costs[i];
			if (temp > avg) {
				if (high.size() == 0) high.add(i);
				else {
					int index = high.size() - 1;
					for (int j = 0; j < high.size(); ++j) {
						int h = high.get(j);
						if (games[h] / costs[h] < temp) {
							index = j;
							break;
						}
					}
					high.add(index, i);
				}
			} else {
				if (low.size() == 0) low.add(i);
				else {
					int index = low.size() - 1;
					for (int j = 0; j < low.size(); ++j) {
						int l = low.get(j);
						if (games[l] / costs[l] < temp) {
							index = j;
							break;
						}
					}
					low.add(index, i);
				}
			}
		}
		int gain = 0;
		Iterator<Integer> hi = high.iterator();
		while (X > 0 && hi.hasNext()) {
			int h = hi.next();
			if ((X -= costs[h]) >= 0) {
				gain += games[h];
			}
		}
		Iterator<Integer> li = low.iterator();
		while (X > 0 && li.hasNext()) {
			int l = li.next();
			if ((X -= costs[l]) >= 0) {
				gain += games[l];
			}
		}
		System.out.println(gain);
	}
}
