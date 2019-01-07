package sword._11_浮点数幂运算;

import java.util.Scanner;

public class _11_FolatExponent {

    private static double exponent(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return multiply(1 / base, -exponent);
        } else {
            return multiply(base, exponent);
        }
    }

    private static double multiply(double base, int exponent) {
        double result = 1.0;

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Base:");
            double base = scanner.nextDouble();
            System.out.print("Exponent:");
            int exponent = scanner.nextInt();
            System.out.println("Result:" + exponent(base, exponent));
        }
    }
}
