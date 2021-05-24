package code_festival_2016_qualc.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (result == 0 && s.charAt(i) == 'C') {
				result = 1;
			} else if (result == 1 && s.charAt(i) == 'F') {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");

	}
}
