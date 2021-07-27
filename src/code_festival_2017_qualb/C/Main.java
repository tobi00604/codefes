package code_festival_2017_qualb.C;

import java.util.*;

// C - 3 Steps
// ���PDF��ǂ�ł������
public class Main {

	static List<List<Integer>> graph; // �O���t
	static int[] color; // �_�̐F

	public static void main(String[] args) {

		// ���͂Ə�����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			graph.get(from).add(to);
			graph.get(to).add(from); // �����O���t�ł���΋t����������
		}
		color = new int[n];
		Arrays.fill(color, 0);

		// �񕔃O���t���ǂ�������
		boolean nibu = checkNibu(0);

		// �m�F�p
//		System.out.println("NO " + Arrays.toString(color));

		// pairs := �_�Ɠ_�̃y�A�̂����ӂłȂ��邱�Ƃ��ł�����̂̐�
		// �񕔃O���t�̏ꍇ�A�����_�ƍ����_�̃y�A����
		// �񕔃O���t�ł͂Ȃ��ꍇ�A���ׂẴy�A
		long pairs = 0;
		if (nibu) {
			for (int v = 0; v < n; v++) {
				pairs += (color[v] == 1) ? 1 : 0;
			}
			pairs *= (long) n - pairs;
		} else {
			pairs = (long) n * ((long) n - 1) / 2;
		}

		// pairs�ӏ��̂���m�ӏ��͂����ӂ�����̂ł���������Z����Γ������o��
		System.out.println(pairs - (long) m);

	}

	// �񕔃O���t���ǂ�����BFS�̗v�̂Ŕ���
	static boolean checkNibu(int s) {

		boolean ret = true;

		// �X�^�[�g�n�_���L���[�ɓ����
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(s);
		color[s] = 1;

		// �L���[����ɂȂ�܂Ń��[�v
		while (!queue.isEmpty()) {

			// �L���[����ЂƂ��o��
			int v = queue.poll();

			// ���̓_���ꂼ�ꏈ��
			for (int next : graph.get(v)) {

				if (color[next] == 0) {
					// ���F�Ȃ�F��h���ăL���[�ɓ����
					color[next] = -color[v];
					queue.add(next);
				} else {
					// �F������Ȃ�񕔃O���t�ɔ����Ă��Ȃ����m�F
					if (color[v] == color[next]) {
						ret = false;
					}
				}
			}

		}

		return ret;
	}
}
