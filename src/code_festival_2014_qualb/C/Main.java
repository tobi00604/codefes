package code_festival_2014_qualb.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// “ü—Í
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();
		int n = s1.length() / 2;

		// Še•¶š‚Ì“oê‰ñ”
		Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> m2 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> m3 = new HashMap<Integer, Integer>();
		for (int i = 'A'; i <= 'Z'; i++) {
			m1.put(i, 0);
			m2.put(i, 0);
			m3.put(i, 0);
		}
		for (int i = 0; i < n * 2; i++) {
			m1.replace(s1.charAt(i) + 0, m1.get(s1.charAt(i) + 0) + 1);
			m2.replace(s2.charAt(i) + 0, m2.get(s2.charAt(i) + 0) + 1);
			m3.replace(s3.charAt(i) + 0, m3.get(s3.charAt(i) + 0) + 1);
		}

		// ”»’èŞ—¿
		int totalP = 0;
		int totalQ = 0;
		for (int i = 'A'; i <= 'Z'; i++) {

			// ‚P‚Â‚ß‚Ì‹à‘®‚©‚çpŒÂ‚Íæ‚ç‚È‚¯‚ê‚Î‚È‚ç‚È‚¢
			int p = Math.max(0, m3.get(i) - m2.get(i));
			totalP += p;

			// ‚P‚Â‚ß‚Ì‹à‘®‚©‚çqŒÂ‚Ü‚Åæ‚Á‚Ä‚¢‚¢
			int q = Math.min(Math.min(m1.get(i), m3.get(i)), n);
			totalQ += q;

			// Šm”F—p
//			System.out.println("‚P‚Â‚ß‚Ì‹à‘®‚©‚çæ‚é" + (char) i + "‚Í" + p + "`" + q + "ŒÂ");

		}

		// ‚±‚½‚¦
		System.out.println((totalP <= n && n <= totalQ) ? "YES" : "NO");

	}
}
