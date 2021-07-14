package code_festival_2016_qualb.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int w = Integer.parseInt(sc.next());
		int h = Integer.parseInt(sc.next());
		long[] p = new long[w];
		for (int i = 0; i < w; i++) {
			p[i] = Long.parseLong(sc.next());
		}
		long[] q = new long[h];
		for (int i = 0; i < h; i++) {
			q[i] = Long.parseLong(sc.next());
		}

		// �c�����Ɖ������̑S���H�����܂Ƃ߂��z�������ăR�X�g�����\�[�g
		Item[] items = new Item[w + h];
		for (int i = 0; i < w; i++) {
			items[i] = new Item(1, p[i]);
		}
		for (int i = 0; i < h; i++) {
			items[w + i] = new Item(2, q[i]);
		}
		Comparator<Item> c = new Comparator<Item>() {
			public int compare(Item task1, Item task2) {
				return Integer.parseInt((task1.val - task2.val) + "");
			}
		};
		Arrays.sort(items, c);

		// �N���X�J���@
		int pDone = 0;
		int qDone = 0;
		long totalCost = 0;
		for (int i = 0; i < w + h; i++) {

			// �m�F�p
			String str = items[i].wh + " : " + items[i].val;
			str += " �i" + pDone + ", " + qDone + "�j COST=" + totalCost;
//			System.out.println(str);

			// �R�X�g���Z
			if (items[i].wh == 1) {
				totalCost += items[i].val * (h + 1 - qDone);
				pDone++; // ����ȍ~�A���������H�͂܂��ЂƂs�v
			} else {
				totalCost += items[i].val * (w + 1 - pDone);
				qDone++; // ����ȍ~�A�c�������H�͂܂��ЂƂs�v
			}

		}

		System.out.println(totalCost);

	}

	static class Item {

		int wh;
		long val;

		// �R���X�g���N�^
		public Item(int wh, long val) {
			this.wh = wh;
			this.val = val;
		}

	}
}
