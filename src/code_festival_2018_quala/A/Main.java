package code_festival_2018_quala.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		int s = Integer.parseInt(sc.next());
		int sum = a + b + c;
		System.out.println((sum <= s && s <= sum + 3) ? "Yes" : "No");

	}
}
