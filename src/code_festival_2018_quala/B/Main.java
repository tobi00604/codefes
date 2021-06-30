package code_festival_2018_quala.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int[] mikan = new int[n];
		Arrays.fill(mikan, b);
		for (int i = 0; i < m; i++) {
			int l = Integer.parseInt(sc.next()) - 1;
			int r = Integer.parseInt(sc.next()) - 1;
			for (int j = l; j <= r; j++) {
				mikan[j] = a;
			}
		}

		// ‚±‚½‚¦
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += mikan[i];
		}
		System.out.println(sum);

	}
}
