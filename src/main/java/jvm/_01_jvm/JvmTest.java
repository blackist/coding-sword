package jvm._01_jvm;

public class JvmTest {

	private int add() {
		int a = 1;
		int b = 2;
		int c = a + b;
		return c;
	}

	public static void main(String[] args) {
		System.out.println(new JvmTest().add());
	}
}
