package sword._09_斐波那契;

public class _01_FibonacciN {

    public static int fibonacci(int n) {
        int result = 0;
        int preOne = 1;
        int preTwo = 0;

        if (n == 0) {
            return preTwo;
        }
        if (n == 1) {
            return preOne;
        }

        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(39));
    }
}
