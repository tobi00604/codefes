package code_festival_2017_qualc.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(s.length() != s.replace("AC", "").length() ? "Yes" : "No");
	}
}
