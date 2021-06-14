package code_festival_2015_quala.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			b[i] = Long.parseLong(sc.next());
		}

		long sum = 0;
		long num = 1;
		for (int i = 0; i < n; i++) {
			sum += b[n - 1 - i] * num;
			num *= 2;
		}
		System.out.println(sum);

	}
}
