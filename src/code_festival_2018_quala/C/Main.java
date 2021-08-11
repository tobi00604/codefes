package code_festival_2018_quala.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ----------
		// ����
		// ----------

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long mod = 1000000000 + 7;

		// K��3000�ȏ�Ȃ�3000�ɂ��Ă���
		int k = Math.min(Integer.parseInt(sc.next()), 3000);

		// A�́u0�ɂ���̂ɕK�v�ȑ���̉񐔁v�ɒu�������Ă���
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = getCnt(Long.parseLong(sc.next()));
		}

		// ----------
		// DP�P���
		// ----------

		// ����������0���܂܂�Ȃ��悤�ɂ���Ƃ���DP
		long[][] dp1 = new long[n][3001];

		// DP�e�[�u����1�s�ځia[0]������1�j
		for (int temp = 0; temp < a[0]; temp++) {
			dp1[0][temp] = 1;
		}

		// DP�e�[�u����2�s�ڈȍ~
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 3000; j++) {
				for (int temp = Math.max(0, j - a[i] + 1); temp <= j; temp++) {
					dp1[i][j] += dp1[i - 1][temp];
					dp1[i][j] %= mod;
				}
			}
		}

		// ----------
		// DP�Q���
		// ----------

		// ����������0���܂܂��悤�ɂ���Ƃ���DP
		long[][] dp2 = new long[n][3001];

		// DP�e�[�u����1�s�ځi1����������1�j
		dp2[0][a[0]] = 1;

		// DP�e�[�u����2�s�ڈȍ~
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
		// ���ʏo��
		// ----------

		// DP�P��ڂ̃e�[�u�����
		long result = dp1[n - 1][k];

		// DP�Q��ڂ̃e�[�u�����
		for (int temp = 0; temp <= k; temp++) {
			result += dp2[n - 1][temp];
			result %= mod;
		}

		// �o��
		System.out.println(result);

	}

	// val��0�ɂ���ɂ͑�������񂷂�΂����������߂ĕԂ��֐�
	static int getCnt(long val) {

		// �ԋp�p
		int ret = 0;

		// 0�ɂȂ�܂Ŕ�����������
		while (val != 0) {
			val /= 2;
			ret++;
		}
		return ret;
	}
}