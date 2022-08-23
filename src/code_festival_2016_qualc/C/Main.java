package code_festival_2016_qualc.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] a = new long[n];
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
		}
		for (int i = 0; i < n; i++) {
			b[i] = Long.parseLong(sc.next());
		}

		// 矛盾ケース
		if (a[n - 1] != b[0]) {
			System.out.println(0);
			return;
		}

		// 左から歩く
		// c[i] = h → i番目の山のありえる高さは h 通り
		// c[i] = 0 → i番目の山のありえる高さは 1 通り
		long[] c = new long[n];
		c[0] = 0;
		for (int i = 1; i < n; i++) {
			c[i] = (a[i - 1] == a[i]) ? a[i] : 0;
		}

		// 右から歩く
		// d[i] = h → i番目の山のありえる高さは h 通り
		// d[i] = 0 → i番目の山のありえる高さは 1 通り
		long[] d = new long[n];
		d[n - 1] = 0;
		for (int i = n - 2; 0 <= i; i--) {
			d[i] = (b[i] == b[i + 1]) ? b[i] : 0;
		}

		// 確認用
//		System.out.println(Arrays.toString(c));
//		System.out.println(Arrays.toString(d));

		// 推理
		// e[i] = h → i番目の山のありえる高さは h 通り
		long[] e = new long[n];
		for (int i = 0; i < n; i++) {
			if (c[i] == 0 || d[i] == 0) {
				e[i] = 1;
				if (c[i] == 0 && d[i] == 0 && a[i] != b[i]) {
					System.out.println(0);
					return;
				}
				if (c[i] == 0 && d[i] != 0 && a[i] > d[i]) {
					System.out.println(0);
					return;
				}
				if (c[i] != 0 && d[i] == 0 && c[i] < b[i]) {
					System.out.println(0);
					return;
				}
			} else {
				e[i] = Math.min(c[i], d[i]);
			}
		}

		// 確認用
//		System.out.println(Arrays.toString(e));

		// こたえ
		long result = 1;
		long mod = 1000000000 + 7;
		for (int i = 0; i < n; i++) {
			result *= e[i];
			result %= mod;
		}
		System.out.println(result);

	}
}
