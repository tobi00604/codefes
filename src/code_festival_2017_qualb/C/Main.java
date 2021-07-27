package code_festival_2017_qualb.C;

import java.util.*;

// C - 3 Steps
// 解説PDFを読んでから実装
public class Main {

	static List<List<Integer>> graph; // グラフ
	static int[] color; // 点の色

	public static void main(String[] args) {

		// 入力と初期化
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // 点の数
		int m = Integer.parseInt(sc.next()); // 辺の数
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // 始点
			int to = Integer.parseInt(sc.next()) - 1; // 終点
			graph.get(from).add(to);
			graph.get(to).add(from); // 無向グラフであれば逆向きもある
		}
		color = new int[n];
		Arrays.fill(color, 0);

		// 二部グラフかどうか判定
		boolean nibu = checkNibu(0);

		// 確認用
//		System.out.println("NO " + Arrays.toString(color));

		// pairs := 点と点のペアのうち辺でつながることができるものの数
		// 二部グラフの場合、白い点と黒い点のペアだけ
		// 二部グラフではない場合、すべてのペア
		long pairs = 0;
		if (nibu) {
			for (int v = 0; v < n; v++) {
				pairs += (color[v] == 1) ? 1 : 0;
			}
			pairs *= (long) n - pairs;
		} else {
			pairs = (long) n * ((long) n - 1) / 2;
		}

		// pairs箇所のうちm箇所はもう辺があるのでそれを引き算すれば答えが出る
		System.out.println(pairs - (long) m);

	}

	// 二部グラフかどうかをBFSの要領で判定
	static boolean checkNibu(int s) {

		boolean ret = true;

		// スタート地点をキューに入れる
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(s);
		color[s] = 1;

		// キューが空になるまでループ
		while (!queue.isEmpty()) {

			// キューからひとつ取り出す
			int v = queue.poll();

			// 次の点それぞれ処理
			for (int next : graph.get(v)) {

				if (color[next] == 0) {
					// 無色なら色を塗ってキューに入れる
					color[next] = -color[v];
					queue.add(next);
				} else {
					// 色があるなら二部グラフに反していないか確認
					if (color[v] == color[next]) {
						ret = false;
					}
				}
			}

		}

		return ret;
	}
}
