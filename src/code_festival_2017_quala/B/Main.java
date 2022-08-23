package code_festival_2017_quala.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		// ・n行のうち何行反転したか
		// ・m列のうち何列反転したか
		// 上記の組み合わせの全探索 O(1000^2)
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				int score = 0;
				score += (n - i) * j;
				score += (m - j) * i;
				System.out.println(i + " " + j + " " + score);
				if (score == k) {
					System.out.println("Yes");
					return;
				}
			}
		}

		System.out.println("No");

	}
}
