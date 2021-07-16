package code_festival_2017_quala.C;

import java.util.*;

// C - Palindromic Matrix
// �e�X�g�P�[�X������~�X�ɋC�t��������
public class Main {

	public static void main(String[] args) {

		// ����
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

		// 4�Ŋ��������܂�ŃO���[�v����
		int[] g = new int[4];
		for (int i = 'a'; i <= 'z'; i++) {
			g[count[i] % 4]++;
		}

		// 2m*2n�T�C�Y�̏ꍇ
		if (h % 2 == 0 && w % 2 == 0) {
			if (g[0] == 26) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			return;
		}

		// (2m+1)*(2n)�T�C�Y�̏ꍇ�i4�l�g��nm��2�l�g��n�j
		if (h % 2 == 0 && w % 2 == 1) {
			int temp = h;
			h = w;
			w = temp;
		}
		if (h % 2 == 1 && w % 2 == 0) {
			if (g[1] > 0 || g[3] > 0) {
				// ��̕�����������A�E�g
				System.out.println("No");
			} else if (g[2] <= w / 2) {
				// g[2] := 2�l�g��P�o�ł��镶���̎�ސ�
				// w/2 := �K�v��2�l�g�̐�
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			return;
		}

		// (2m+1)*(2n+1)�T�C�Y�̏ꍇ�i4�l�g��nm��2�l�g��(n+m)��1�l�j
		if (h % 2 == 1 && w % 2 == 1) {
			if (g[1] == 1 && g[3] == 0) {
				g[1]--;
				g[0]++;
			} else if (g[1] == 0 && g[3] == 1) {
				g[3]--;
				g[2]++;
			} else {
				// ����]���Ă���A�E�g
				System.out.println("No");
				return;
			}

			int z = ((h - 1) / 2) + ((w - 1) / 2);
			if (g[2] <= z) {
				// g[2] := 2�l�g��P�o�ł��镶���̎�ސ�
				// z := �K�v��2�l�g�̐�
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			return;
		}

	}
}
