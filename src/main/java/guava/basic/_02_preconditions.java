package guava.basic;

import com.google.common.base.Preconditions;

/**
 * TODO 前提条件
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2020/1/9
 */
public class _02_preconditions {

	public static void main(String[] args) {
		int i = -1;
		int j = 0;
		String s = "Not Null";
		try {
			Preconditions.checkArgument(i > j);
			Preconditions.checkArgument(i > j, "Expected i < j, but %s >= %s", i, j);
			Preconditions.checkArgument(i > 0, "Argument is %s but expected nonnegtive", i);
			String nonNull = Preconditions.checkNotNull(s);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
