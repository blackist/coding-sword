package leetcode.netease;

import java.util.Scanner;

/**
 * TODO ${TODO}
 *
 * @author LiangLiang.Dong<liangl.dong @ qq.com>
 * @since 2019/7/31 18:48.
 */
public class Cos2019_03AppleHeap {

    public static void main(String[] args) {

        //时间换空间的思想
        try (Scanner input = new Scanner(System.in)) {
            int n = input.nextInt();
            int count = 0; //保存苹果总数,用于创建数组
            int[] apple = new int[n + 1]; //用数组保存苹果
            for (int i = 1; i <= n; i++) {
                apple[i] = input.nextInt();
                count += apple[i];
            }

            int[] arr = new int[count + 1];
            count = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = count + 1; j <= apple[i] + count; j++) {
                    arr[j] = i;
                }
                count += apple[i];
            }
            int m = input.nextInt();
            for (int i = 0; i < m; i++) {
                System.out.println(arr[input.nextInt()]);
            }
        }
    }

    /**
     * 30%
     */
    public static void my() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += scanner.nextInt();
            arr[i] = count;
        }
        int m = scanner.nextInt();
        int[] aim = new int[m];
        for (int i = 0; i < m; ++i) {
            aim[i] = scanner.nextInt();
        }

        for (int j = 0; j < m; ++j) {
            System.out.println(sort(arr, aim[j]));
        }
    }

    public static int sort(int[] arr, int key) {
        int low = 0, high = arr.length - 1, mid;
        while (low < high) {
            mid = (high + low) / 2;
            if (arr[mid] == key) {
                return mid + 1;
            } else if (key < arr[low]) {
                return low + 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high + 1;
    }
}
