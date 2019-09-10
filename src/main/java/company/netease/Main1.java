package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO AS
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/3
 */
public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		int n = Integer.parseInt(line);
		String[] line1 = br.readLine().trim().split(" ");
		int[] arr = new int[n];
		int[] pos = new int[n];
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line1[i]);
			pos[i] = i;
			sum += arr[i];
		}

		for(int i=0;i<n-1;i++){

			int minIndex = i;
			for(int j=i+1;j<n;j++){
				if(arr[j]<arr[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				int temp = arr[i];
				int temp_i = i;

				arr[i] = arr[minIndex];
				pos[i] = pos[minIndex];

				arr[minIndex] = temp;
				pos[minIndex] = temp_i;
			}
		}

		int q = Integer.parseInt(br.readLine().trim());
		int[] qrr = new int[q];
		for (int i = 0; i < q; i++) {
			qrr[i] = Integer.parseInt(br.readLine().trim());
		}
		double na = (double) n;
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < n; j++) {
				if (pos[j] == qrr[i] -1) {
					System.out.format("%.6f\n", j/na * 100);
				}
			}
		}

		
	}
}
