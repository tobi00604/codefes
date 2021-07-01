package code_festival_2018_qualb.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int score = 0;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			temp = Math.max(temp, b);
			score += a * b;
		}
		score += temp * x;
		System.out.println(score);

	}
}
