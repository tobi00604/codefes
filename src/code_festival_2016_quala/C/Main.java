package code_festival_2016_quala.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String answer = "";
		int k = Integer.parseInt(sc.next());

		// 各文字について
		for (int i = 0; i < s.length(); i++) {

			// i文字目を'a'にできるならする
			if (s.charAt(i) != 'a' && 'z' - s.charAt(i) + 1 <= k) {
				answer += "a";
				k -= 'z' - s.charAt(i) + 1;
			} else {
				answer += s.charAt(i) + "";
			}

		}

		// 確認用
//		System.out.println(k);
//		System.out.println(answer);

		// 余ったkを使って最後の文字を循環させる
		k %= 26;
		char x = answer.charAt(answer.length() - 1);
		for (int i = 0; i < k; i++) {
			if (x == 'z') {
				x = 'a';
			} else {
				x++;
			}
		}

		System.out.println(answer.substring(0, answer.length() - 1) + x);

	}
}
