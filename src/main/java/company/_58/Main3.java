package company._58;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 坐标
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/12
 */
public class Main3 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String line0 = br.readLine().trim();
	    int n = Integer.parseInt(line0);
		String line1 = br.readLine().trim();
		int m = Integer.parseInt(line1);
	    int[][] arr = new int[n][m];
	    for (int i = 0; i < n; i++) {
	        String[] line2 = br.readLine().split(" ");
	        for (int j=0;j<m;++j) {
				arr[i][j] = Integer.parseInt(line2[0]);
			}
	    }
	}

	private static void func() {

	}
}
