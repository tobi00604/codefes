package code_festival_2017_qualc.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.next();
		String inputStrWithoutX = inputStr.replace("x", "");

		// 答えが0になるか判定
		if (checkPalindrome(inputStr)) {
			System.out.println(0);
			return;
		}

		// 答えが-1になるか判定
		if (!checkPalindrome(inputStrWithoutX)) {
			System.out.println(-1);
			return;
		}

		// 各隙間にxがいくつあるか
		int[] a = new int[inputStrWithoutX.length() + 1];
		int j = 0;
		for (int i = 0; i < inputStr.length(); i++) {
			if (inputStr.charAt(i) == 'x') {
				a[j]++;
			} else {
				j++;
			}
		}

		// 答えを求める
		int result = 0;
		for (int i = 0; i < a.length / 2; i++) {
			result += Math.abs(a[i] - a[a.length - 1 - i]);
		}

//		System.out.println(Arrays.toString(a));
		System.out.println(result);

	}

	// 回文かどうか判定
	static boolean checkPalindrome(String str) {

		for (int i = 0; i < str.length() / 2; i++) {
			int j = str.length() - 1 - i;
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}

		return true;
	}
}
