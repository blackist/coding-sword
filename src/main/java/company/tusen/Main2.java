package company.tusen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 员工数
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/9/28
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] line0 = br.readLine().trim().split(" ");
	    int n = Integer.parseInt(line0[0]);
	    int m = Integer.parseInt(line0[1]);

	    int[] arr = new int[m];
	    for (int i = 0; i < m; i++) {
	        String[] line1 = br.readLine().trim().split(" ");
	        arr[i] = Integer.parseInt(line1[0]);
	    }
	}

	private static void solution() {
		long f = 0x1FFFF;
		// long[]
	}
}
