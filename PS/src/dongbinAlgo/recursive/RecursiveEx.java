package dongbinAlgo.recursive;

public class RecursiveEx {
    public static void main(String[] args) {
        recursive(0);
    }

    private static void recursive(int i) {
        if (i == 100) {
            return ;
        }
        System.out.printf("%d번째 재귀 함수를 호출합니다.\n", i + 1);
        recursive(i + 1);
    }

}
