import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strings = br.readLine().split(" ");
		int k = Integer.parseInt(strings[0]);
		int n = Integer.parseInt(strings[1]);

		int[] lines = new int[k];
		long max = 0;
		for (int i = 0; i < k; i++) {
			lines[i] = Integer.parseInt(br.readLine());

			if (max < lines[i]) {
				max = lines[i];
			}
		}

		max++;

		long min = 0;
		long mid = 0;

		while (min < max) {
			mid = (min + max) / 2;

			long sum = 0;

			for (int i = 0; i < lines.length; i++) {
				sum += lines[i] / mid;
			}

			if (sum < n) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);	// upperbound - 1

	}

}
