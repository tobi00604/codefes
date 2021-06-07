package code_festival_2014_quala.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		int t = Integer.parseInt(sc.next()) % n;
		if (t % n == 0) {
			System.out.println(s.charAt(n - 1) + "");
		} else {
			System.out.println(s.charAt(t - 1) + "");
		}

	}
}
