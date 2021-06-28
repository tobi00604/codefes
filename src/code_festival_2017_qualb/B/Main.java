package code_festival_2017_qualb.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
		}
		int m = Integer.parseInt(sc.next());
		long[] b = new long[m];
		for (int i = 0; i < m; i++) {
			b[i] = Long.parseLong(sc.next());
		}
		Arrays.sort(a);
		Arrays.sort(b);

		// �m�F�p
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));

		int c = 0;
		for (int i = 0; i < m; i++) {
			while (c < n && a[c] != b[i]) {
				c++;
			}

			// �m�F�p
//			System.out.println(c + " " + i);

			if (c == n) {
				System.out.println("NO");
				return;
			}
			c++;
		}

		System.out.println("YES");

	}
}
