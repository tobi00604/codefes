package code_festival_2016_quala.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// �e�������ɂ���
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (i < a[i] && a[a[i]] == i) {
				result++;
			}
		}
		System.out.println(result);

	}
}
