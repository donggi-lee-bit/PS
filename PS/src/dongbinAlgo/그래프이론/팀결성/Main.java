package dongbinAlgo.그래프이론.팀결성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n, m;
    public static int[] parent = new int[100001];

    public static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] strings1 = br.readLine().split(" ");
            int oper = Integer.parseInt(strings1[0]);
            int a = Integer.parseInt(strings1[1]);
            int b = Integer.parseInt(strings1[2]);

            if (oper == 0) {
                unionParent(a, b);
            } else if (oper == 1) {
                if (findParent(a) == findParent(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
