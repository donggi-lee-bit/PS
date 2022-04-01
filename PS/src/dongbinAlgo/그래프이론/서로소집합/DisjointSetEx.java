package dongbinAlgo.그래프이론.서로소집합;

public class DisjointSetEx {

    static int[] parent = new int[10];
    static int[] rank = new int[parent.length];

    public static void main(String[] args) {

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        printSet();
        union(0, 1);
        printSet();
        union(3, 5);
        printSet();
        union(0, 3);
        printSet();
    }

    private static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px != py) {
            parent[py] = px;
        }
    }

    private static int findSet(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            parent[x] = findSet(parent[x]);
            return parent[x];
        }
    }

    private static void printSet() {
        System.out.println("index: ");
        for (int i = 0; i < parent.length; i++) {
            System.out.println(i + " ");
        }
        System.out.println();

        System.out.println("parent: ");
        for (int i = 0; i < parent.length; i++) {
            System.out.println(parent[i] + " ");
        }
        System.out.println();
    }
}
