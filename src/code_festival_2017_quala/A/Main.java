package code_festival_2017_quala.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if (s.length() <= 3) {
			System.out.println("No");
			return;
		}
		if (s.charAt(0) == 'Y' && s.charAt(1) == 'A' && s.charAt(2) == 'K' && s.charAt(3) == 'I') {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}
}
