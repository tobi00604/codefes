package code_festival_2016_qualb.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s1 = "CODEFESTIVAL2016";
		String s2 = sc.next();
		int result = 0;
		for (int i = 0; i < s1.length(); i++) {
			result += (s1.charAt(i) == s2.charAt(i)) ? 0 : 1;
		}
		System.out.println(result);

	}
}
