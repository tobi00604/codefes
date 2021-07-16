package code_festival_2017_quala.C;

import java.util.*;

// C - Palindromic Matrix
// テストケース見たらミスに気付いたかも
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		int[] count = new int[999999];
		for (int i = 0; i < h; i++) {
			String s = sc.next();
			for (int j = 0; j < w; j++) {
				count[s.charAt(j)]++;
			}
		}

		// 4で割ったあまりでグループ分け
		int[] g = new int[4];
		for (int i = 'a'; i <= 'z'; i++) {
			g[count[i] % 4]++;
		}

		// 2m*2nサイズの場合
		if (h % 2 == 0 && w % 2 == 0) {
			if (g[0] == 26) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			return;
		}

		// (2m+1)*(2n)サイズの場合（4人組がnm個と2人組がn個）
		if (h % 2 == 0 && w % 2 == 1) {
			int temp = h;
			h = w;
			w = temp;
		}
		if (h % 2 == 1 && w % 2 == 0) {
			if (g[1] > 0 || g[3] > 0) {
				// 奇数の文字がいたらアウト
				System.out.println("No");
			} else if (g[2] <= w / 2) {
				// g[2] := 2人組を捻出できる文字の種類数
				// w/2 := 必要な2人組の数
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			return;
		}

		// (2m+1)*(2n+1)サイズの場合（4人組がnm個と2人組が(n+m)個と1人）
		if (h % 2 == 1 && w % 2 == 1) {
			if (g[1] == 1 && g[3] == 0) {
				g[1]--;
				g[0]++;
			} else if (g[1] == 0 && g[3] == 1) {
				g[3]--;
				g[2]++;
			} else {
				// 奇数が余ってたらアウト
				System.out.println("No");
				return;
			}

			int z = ((h - 1) / 2) + ((w - 1) / 2);
			if (g[2] <= z) {
				// g[2] := 2人組を捻出できる文字の種類数
				// z := 必要な2人組の数
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			return;
		}

	}
}
