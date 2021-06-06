package code_festival_2018_qualb.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			count += (i % a != 0) ? 1 : 0;
		}
		System.out.println(count);

	}
}
