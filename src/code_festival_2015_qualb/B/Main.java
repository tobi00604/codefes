package code_festival_2015_qualb.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(a);

		int l = 0;
		int r = n / 2;
		while (r != n) {
			if (a[l] == a[r]) {
				System.out.println(a[l]);
				return;
			}
			l++;
			r++;
		}

		System.out.println("?");

	}
}
