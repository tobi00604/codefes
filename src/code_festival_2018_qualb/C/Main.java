package code_festival_2018_qualb.C;

import java.util.*;

public class Main {

	static String[][] a;
	static int n;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		a = new String[n][n];

		// �R�[�i�[�P�[�X�An=1�������瓚����"X"
		if (n == 1) {
			System.out.println("X");
			return;
		}

		// �s���Ƃ̃X�v���[�J�n�ʒu
		int[] begin = new int[5];
		begin[0] = 0;
		begin[1] = 2;
		begin[2] = 4;
		begin[3] = 1;
		begin[4] = 3;

		// ����
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = (j % 5 == begin[i % 5]) ? "X" : ".";
			}
		}

		// �S�ӂ͒ǉ��X�v���[���K�v
		for (int i = 0; i < n; i++) {
			a[0][i] = safe(0, i) ? "Y" : a[0][i];
			a[n - 1][i] = safe(n - 1, i) ? "Y" : a[n - 1][i];
			a[i][0] = safe(i, 0) ? "Y" : a[i][0];
			a[i][n - 1] = safe(i, n - 1) ? "Y" : a[i][n - 1];
		}

		// �X�v���[�ӏ��m�F�p
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(a[i]).replace(", ", "").replace("[", "").replace("]", ""));
//		}

		// �X�v���[�񐔊m�F�p
//		int count = 0;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				count += (a[i][j].equals("X") || a[i][j].equals("Y")) ? 1 : 0;
//			}
//		}
//		System.out.println(count);

		// ������
		for (int i = 0; i < n; i++) {
			System.out.println(
					Arrays.toString(a[i]).replace("Y", "X").replace(", ", "").replace("[", "").replace("]", ""));
		}

	}

	// �}�X(i, j)���܂��H�ׂ����Ԃ��ǂ�������
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
