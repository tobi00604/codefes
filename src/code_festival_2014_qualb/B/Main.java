package code_festival_2014_qualb.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long k = Long.parseLong(sc.next());
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			b[i] = Long.parseLong(sc.next());
		}

		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += b[i];
			if (k <= sum) {
				System.out.println(i + 1);
				return;
			}
		}

	}
}
