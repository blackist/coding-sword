package leetcode.didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO 序列移除
 *
 * 现在有A，B两个序列，两个序列都是拥有n个元素，你有两种操作：
 *
 * 1. 从A序列中选择一个非空前缀，再从B序列中选择一个非空前缀，要求选择的这两个前缀的末尾元素相等。把这两个前缀移除，这个操作将花费Cost代价，但是这个操作可以使你得到一颗宝石。
 *
 * 2. 您可以重复第1步的操作；最终，您需要花费两个序列剩余元素数量之和大小的代价，移除两个序列中剩下的所有元素（这最后一步是没有宝石的），这时游戏结束。
 *
 * 要求总代价不超过Total，且序列中不得有剩余，那么最多可以获得多少宝石。
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/27
 */
public class Main2 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] line0 = br.readLine().trim().split(" ");
	    int n = Integer.parseInt(line0[0]);
	    int m = Integer.parseInt(line0[1]);

	    int[] arr = new int[m];
	    for (int i = 0; i < m; i++) {
	        String[] line1 = br.readLine().split(" ");
	        arr[i] = Integer.parseInt(line1[0]);
	    }
	}

	private static void func() {

	}
}
