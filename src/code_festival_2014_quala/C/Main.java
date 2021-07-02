package code_festival_2014_quala.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		// Šm”F
//		System.out.println(f(a, b, 4));
//		System.out.println(f(a, b, 100));
//		System.out.println(f(a, b, 400));

		System.out.println(f(a, b, 4) - f(a, b, 100) + f(a, b, 400));

	}

	static long f(long p, long q, long r) {
		long x = (p - 1) / r;
		long y = (q) / r;
		return y - x;
	}
}
