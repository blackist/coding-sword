package company.netease;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * TODO ${TODO}
 *
 * @author LiangLiang.Dong<liangl.dong @ qq.com>
 * @since 2019/7/31 18:48.
 */
public class Cos2019_04Garbage {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line0 = br.readLine().split(" ");
        int n = Integer.parseInt(line0[0]);
        int m = Integer.parseInt(line0[1]);
        int k = Integer.parseInt(line0[2]);
        int[] arr = new int[n];
        for (int i = 0; i < m; ++i) {
            // int t = scanner.nextInt();
            // arr[t-1]++;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
