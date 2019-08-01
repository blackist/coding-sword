package leetcode.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO ${TODO}
 *
 * @author LiangLiang.Dong<liangl.dong @ qq.com>
 * @since 2019/7/31 18:48.
 */
public class Cos2019_01Tetris {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < m; ++i) {
            int t = scanner.nextInt();
            arr[t-1]++;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
