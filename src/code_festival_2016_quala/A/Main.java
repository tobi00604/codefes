package code_festival_2016_quala.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String result = "";
		for (int i = 0; i < 12; i++) {
			result += s.charAt(i) + "";
			if (i == 3) {
				result += " ";
			}
		}
		System.out.println(result);

	}
}
