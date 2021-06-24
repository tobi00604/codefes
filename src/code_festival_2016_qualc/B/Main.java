package code_festival_2016_qualc.B;

import java.util.*;

public class Main {

	// K個のケーキ
	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(a);

		// コーナーケース ケーキが１種類の場合
		if (n == 1) {
			System.out.println(k - 1);
			return;
		}

		// あとで余るケーキの数
		int amari = Math.max(0, a[n - 1] - a[n - 2] - 1);

		// あとで余るケーキを割り込ませられる隙間の数
		int sukima = 0;
		for (int i = 0; i < n - 2; i++) {
			sukima += a[i];
		}

		// 確認用
//		System.out.println(amari);
//		System.out.println(sukima);

		// こたえ
		if (sukima < amari) {
			System.out.println(amari - sukima);
		} else {
			System.out.println(0);
		}

	}
}
