package boj.듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());	// 듣도 못한 사람의 수 N
		int M = Integer.parseInt(st.nextToken());	// 보도 못한 사람의 수 M

		String[] arr = new String[N];
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N + M; i++) {

			if (i < N) {
				arr[i] = br.readLine();
			} else {
				String duplicatedName = br.readLine();
				for (int j = 0; j < N; j++) {
					if (arr[j].equals(duplicatedName)) {

						Arrays.sort(list, new Comparator<String>() {

							@Override
							public int compare(String o1, String o2) {
								if (o1.charAt(n) > o2.charAt(n))
							}
						})


						list.add(duplicatedName);
					}
				}
			}
		}
	}
}
