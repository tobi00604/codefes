package code_festival_2018_quala.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ----------
		// 入力
		// ----------

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long mod = 1000000000 + 7;

		// Kは3000以上なら3000にしていい
		int k = Math.min(Integer.parseInt(sc.next()), 3000);

		// Aは「0にするのに必要な操作の回数」に置き換えておく
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = getCnt(Long.parseLong(sc.next()));
		}

		// ----------
		// DP１回目
		// ----------

		// 作った数列に0が含まれないようにするときのDP
		long[][] dp1 = new long[n][3001];

		// DPテーブルの1行目（a[0]ヶ所が1）
		for (int temp = 0; temp < a[0]; temp++) {
			dp1[0][temp] = 1;
		}

		// DPテーブルの2行目以降
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 3000; j++) {
				for (int temp = Math.max(0, j - a[i] + 1); temp <= j; temp++) {
					dp1[i][j] += dp1[i - 1][temp];
					dp1[i][j] %= mod;
				}
			}
		}

		// ----------
		// DP２回目
		// ----------

		// 作った数列に0が含まれるようにするときのDP
		long[][] dp2 = new long[n][3001];

		// DPテーブルの1行目（1ヶ所だけが1）
		dp2[0][a[0]] = 1;

		// DPテーブルの2行目以降
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 3000; j++) {
				for (int temp = Math.max(0, j - a[i]); temp <= j; temp++) {
					dp2[i][j] += dp2[i - 1][temp];
					dp2[i][j] %= mod;
				}
				if (0 <= j - a[i]) {
					dp2[i][j] += dp1[i - 1][j - a[i]];
					dp2[i][j] %= mod;
				}
			}
		}

		// ----------
		// 結果出力
		// ----------

		// DP１回目のテーブルより
		long result = dp1[n - 1][k];

		// DP２回目のテーブルより
		for (int temp = 0; temp <= k; temp++) {
			result += dp2[n - 1][temp];
			result %= mod;
		}

		// 出力
		System.out.println(result);

	}

	// valを0にするには操作を何回すればいいかを求めて返す関数
	static int getCnt(long val) {

		// 返却用
		int ret = 0;

		// 0になるまで半減し続ける
		while (val != 0) {
			val /= 2;
			ret++;
		}
		return ret;
	}
}