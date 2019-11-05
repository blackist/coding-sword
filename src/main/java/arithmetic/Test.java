package arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO test
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/10/23
 */
public class Test {

	public static void main(String[] args) {
		Test m = new Test();
	}

	public Object m() {
		Object o = new Float(3.14F);
		Object[] oa = new Object[1];
		oa[0] = o;
		o = null;
		oa[0] = null;
		return null;
	}

	public int aMethod() {
		// 编译错误
		// static int i = 0;
		// i++;
		return 0;
	}

	void fermin(int i) {
		i++;
	}

	public int get() {
		try {
			return 1;
		} finally {
			return 2;
		}
	}

	public int rabbit() {
		int f1 = 1;
		int f2 = 1;
		int f = 0;
		for (int i = 2; i < 24; i++) {
			f = f1;
			f1 = f1 + f2;
			f2 = f;
		}
		return f;
	}

	class HaveString {
		public String val;

		public HaveString(String val) {
			this.val = val;
		}
	}

	public void haveString() {
		List<HaveString> str = new ArrayList<>();
		str.add(new HaveString("a"));
		str.add(new HaveString("b"));
		str.add(new HaveString("c"));
		str.add(new HaveString("d"));

		List<HaveString> strCopy = new ArrayList<>();
		for (HaveString e : str) {
			strCopy.add(e);
		}
		for (int i = 0; i < strCopy.size(); i++) {
			if (strCopy.get(i).val.equals("c")) {
				strCopy.get(i).val += "new";
			}
		}
		for (HaveString e : str) {
			System.out.println(e.val + " ");
		}
	}
}
