package code_festival_2016_qualc.B;

import java.util.*;

public class Main {

	// K�̃P�[�L
	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(a);

		// �R�[�i�[�P�[�X �P�[�L���P��ނ̏ꍇ
		if (n == 1) {
			System.out.println(k - 1);
			return;
		}

		// ���Ƃŗ]��P�[�L�̐�
		int amari = Math.max(0, a[n - 1] - a[n - 2] - 1);

		// ���Ƃŗ]��P�[�L�����荞�܂����錄�Ԃ̐�
		int sukima = 0;
		for (int i = 0; i < n - 2; i++) {
			sukima += a[i];
		}

		// �m�F�p
//		System.out.println(amari);
//		System.out.println(sukima);

		// ������
		if (sukima < amari) {
			System.out.println(amari - sukima);
		} else {
			System.out.println(0);
		}

	}
}
