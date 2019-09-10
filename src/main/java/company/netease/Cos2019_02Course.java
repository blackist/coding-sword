package company.netease;

import java.util.Scanner;

/**
 * TODO ${TODO}
 *
 * @author LiangLiang.Dong<liangl.dong @ qq.com>
 * @since 2019/7/31 18:48.
 */
public class Cos2019_02Course {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n;
        int k;
        while (s.hasNext()) {
            n = s.nextInt();
            k = s.nextInt();
            int max = 0;//被重新叫醒后可得的最高分。
            int sum = 0;//表示总的分数
            int[] a = new int[n];
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            int now = 0;
            for (int i = 0; i < n; i++) {
                t[i] = s.nextInt();
                now += t[i] * a[i];
            }

            int res = now;
            for (int i = 0; i < n; ) {
                if (t[i] == 0) {
                    now += 1 * a[i];
                }
                if (++i >= k) {
                    res = Math.max(res, now);
                    if (i-k<n&&i-k>=0) {
                        if (t[i-k] == 0) {
                            now -= 1 * a[i-k];
                        }
                    }
                }

            }
            System.out.println(res);

        }
        // Scanner scanner = new Scanner(System.in);
        // int m = scanner.nextInt();
        // int k = scanner.nextInt();
        // int ins[] = new int[m];
        // int sleep[] = new int[m];
        // for (int i = 0; i < m; ++i) {
        //     ins[i] = scanner.nextInt();
        // }
        // for (int i = 0; i < m; ++i) {
        //     sleep[i] = scanner.nextInt();
        // }
        //
        // int max = 0;
        // int remain = 0;
        // for (int j = 0; j <= m - k; ++j) {
        //     int sum = 0;
        //     boolean movd_l = true;
        //     boolean movd_r = true;
        //     int mov_l = 0;
        //     int mov_r = 0;
        //     for (int l = 0; l < k; ++l) {
        //         sum += ins[j + l];
        //         if (movd_l && sleep[j + l] == 0 && j + k + l < m) {
        //             mov_l += ins[j + k + l];
        //         } else {
        //             movd_l = false;
        //         }
        //         if (movd_r && sleep[j + k - l - 1] == 0 && j - l - 1 >= 0) {
        //             mov_r += ins[j - l - 1];
        //         } else {
        //             movd_r = false;
        //         }
        //     }
        //     if (max < sum) {
        //         max = sum;
        //         remain = mov_l > mov_r ? mov_l : mov_r;
        //     }
        // }
        // System.out.println(max + remain);

    }
}
