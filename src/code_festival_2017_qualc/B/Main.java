package code_festival_2017_qualc.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		int entire = 1;
		int temp = 1;
		for (int i = 0; i < n; i++) {
			entire *= 3;
			temp *= (a[i] % 2 == 0) ? 2 : 1;
		}

		System.out.println(entire - temp);

	}
}
