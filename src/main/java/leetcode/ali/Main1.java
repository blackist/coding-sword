package leetcode.ali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * TODO 盒马配货
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/8/26
 */
public class Main1 {

	private static String polygon(List<Double> x_s, List<Double> y_s, double x, double y) {

		double[] xs = new double[x_s.size()];
		for (int i = 0; i < x_s.size(); i++)
			xs[i] = x_s.get(i);
		double[] ys = new double[y_s.size()];
		for (int i = 0; i < y_s.size(); i++)
			ys[i] = y_s.get(i);

		boolean contained = false;

		double xMin = Arrays.stream(xs).min().getAsDouble();
		double xMax = Arrays.stream(xs).max().getAsDouble();
		double yMin = Arrays.stream(ys).min().getAsDouble();
		double yMax = Arrays.stream(ys).max().getAsDouble();

		if (x > xMax || x < xMin || y > yMax || y < yMin) {
			contained = false;
		}

		int N = xs.length;
		double dist = Double.MAX_VALUE;
		for (int i = 0, j = N - 1; i < N; j = i++) {
			if (((ys[j] > y) != (ys[i] > y))
					&& (x < (xs[j] - xs[i]) * (y - ys[i]) / (ys[j] - ys[i]) + xs[i])) {
				contained = !contained;
			}
			dist = Math.min(dist, pointToSegmentDist(x, y, xs[i], ys[i], xs[j], ys[j]));
		}

		return contained ? "no 0" : "yes" + " " + dist;
	}

	private static double pointToSegmentDist(double px, double py, double ax, double ay, double bx, double by) {

		double ABx = bx - ax;
		double ABy = by - ay;
		double APx = px - ax;
		double APy = py - ay;

		double AB_AP = ABx * APx + ABy * APy;
		double distAB2 = ABx * ABx + ABy * ABy;

		double Dx = ax, Dy = ay;
		if (distAB2 != 0) {
			double t = AB_AP / distAB2;
			if (t >= 1) {
				Dx = bx;
				Dy = by;
			} else if (t > 0) {
				Dx = ax + ABx * t;
				Dy = ay + ABy * t;
			} else {
				Dx = ax;
				Dy = ay;
			}
		}

		double PDx = Dx - px, PDy = Dy - py;

		return Math.sqrt(PDx * PDx + PDy * PDy);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		// (x,y)为小广所在的位置
		double x = Double.parseDouble(line.split(",")[0]);
		double y = Double.parseDouble(line.split(",")[1]);

		line = in.nextLine();
		// xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
		List<Double> xList = new ArrayList<>();
		List<Double> yList = new ArrayList<>();
		String[] array = line.split(",");
		for (int i = 0; i < array.length; i++) {
			xList.add(Double.parseDouble(array[i]));
			yList.add(Double.parseDouble(array[i + 1]));
			i++;
		}
		in.close();
		System.out.println(polygon(xList, yList, x, y));
	}
}
