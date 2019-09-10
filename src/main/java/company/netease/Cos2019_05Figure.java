package company.netease;

import java.util.Scanner;

/**
 * TODO ${TODO}
 *
 * @author LiangLiang.Dong<liangl.dong @ qq.com>
 * @since 2019/7/31 18:48.
 */
public class Cos2019_05Figure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < 3; ++i) {
            arr[i] = scanner.nextInt();
        }


        System.out.println(Math.max(max_(max_(arr[0], arr[1]), arr[2]), max_(arr[0],max_(arr[1], arr[2]))));
    }

    public static int max_(int a, int b) {
        return Math.max(a + b, a * b);
    }
}
