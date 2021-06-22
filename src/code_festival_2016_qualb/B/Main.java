package code_festival_2016_qualb.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next()); // Yes‚É‚È‚éŠCŠOŠw¶
		int p = a + b; // ’èˆõ
		String s = sc.next();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				if (0 < p) {
					System.out.println("Yes");
					p--;
				} else {
					System.out.println("No");
				}
			} else if (s.charAt(i) == 'b') {
				if (0 < p && 0 < b) {
					System.out.println("Yes");
					p--;
					b--;
				} else {
					System.out.println("No");
				}
			} else if (s.charAt(i) == 'c') {
				System.out.println("No");
			}
		}

	}
}
