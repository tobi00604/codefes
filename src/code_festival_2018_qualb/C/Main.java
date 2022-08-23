package code_festival_2018_qualb.C;

import java.util.*;

public class Main {

	static String[][] a;
	static int n;

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		a = new String[n][n];

		// コーナーケース、n=1だったら答えは"X"
		if (n == 1) {
			System.out.println("X");
			return;
		}

		// 行ごとのスプレー開始位置
		int[] begin = new int[5];
		begin[0] = 0;
		begin[1] = 2;
		begin[2] = 4;
		begin[3] = 1;
		begin[4] = 3;

		// 生成
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = (j % 5 == begin[i % 5]) ? "X" : ".";
			}
		}

		// ４辺は追加スプレーが必要
		for (int i = 0; i < n; i++) {
			a[0][i] = safe(0, i) ? "Y" : a[0][i];
			a[n - 1][i] = safe(n - 1, i) ? "Y" : a[n - 1][i];
			a[i][0] = safe(i, 0) ? "Y" : a[i][0];
			a[i][n - 1] = safe(i, n - 1) ? "Y" : a[i][n - 1];
		}

		// スプレー箇所確認用
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(a[i]).replace(", ", "").replace("[", "").replace("]", ""));
//		}

		// スプレー回数確認用
//		int count = 0;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				count += (a[i][j].equals("X") || a[i][j].equals("Y")) ? 1 : 0;
//			}
//		}
//		System.out.println(count);

		// こたえ
		for (int i = 0; i < n; i++) {
			System.out.println(
					Arrays.toString(a[i]).replace("Y", "X").replace(", ", "").replace("[", "").replace("]", ""));
		}

	}

	// マス(i, j)がまだ食べられる状態かどうか判定
	static boolean safe(int i, int j) {

		if (a[i][j].equals("X")) {
			return false;
		}

		if (i + 1 != n) {
			if (a[i + 1][j].equals("X")) {
				return false;
			}
		}

		if (i - 1 != -1) {
			if (a[i - 1][j].equals("X")) {
				return false;
			}
		}

		if (j + 1 != n) {
			if (a[i][j + 1].equals("X")) {
				return false;
			}
		}

		if (j - 1 != -1) {
			if (a[i][j - 1].equals("X")) {
				return false;
			}
		}

		return true;
	}

}
