package code_festival_2015_quala.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long t = Long.parseLong(sc.next());
		long sum = 0L;
		long p[] = new long[n];
		for (int i = 0; i < n; i++) {
			long a = Long.parseLong(sc.next());
			long b = Long.parseLong(sc.next());
			sum += a;
			p[i] = a - b;
		}
		Arrays.sort(p);

		// Œø‰Ê‚Ì‘å‚«‚¢‚à‚Ì‚©‚çŽg‚Á‚Ä‚¢‚­
		for (int i = 0; i < n; i++) {
			if (sum <= t) {
				System.out.println(i);
				return;
			} else {
				sum -= p[n - 1 - i];
			}
		}

		if (sum <= t) {
			System.out.println(n);
			return;
		}

		System.out.println(-1);

	}
}
