package code_festival_2016_quala.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String answer = "";
		int k = Integer.parseInt(sc.next());

		// �e�����ɂ���
		for (int i = 0; i < s.length(); i++) {

			// i�����ڂ�'a'�ɂł���Ȃ炷��
			if (s.charAt(i) != 'a' && 'z' - s.charAt(i) + 1 <= k) {
				answer += "a";
				k -= 'z' - s.charAt(i) + 1;
			} else {
				answer += s.charAt(i) + "";
			}

		}

		// �m�F�p
//		System.out.println(k);
//		System.out.println(answer);

		// �]����k���g���čŌ�̕������z������
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
