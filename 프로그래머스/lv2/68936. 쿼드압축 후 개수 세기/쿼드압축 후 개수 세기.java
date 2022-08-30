class Solution {
    int oneValueCount;
    int zeroValueCount;

    public int[] solution(int[][] arr) {
        int length = arr.length;

        recursive(arr, 0, 0, length);

        return new int[]{zeroValueCount, oneValueCount};
    }

    private void recursive(int[][] arr, int x, int y, int length) {
        // 탈출 조건
        if (length == 1) {
            if (arr[x][y] == 0) {
                zeroValueCount++;
                return;
            } else {
                oneValueCount++;
                return;
            }
        }
        // 재귀 로직

        if (!checked(arr, x, y, length)) {
            recursive(arr, x, y, length / 2);
            recursive(arr, x, y + length / 2, length / 2);
            recursive(arr, x + length / 2, y, length / 2);
            recursive(arr, x + length / 2, y + length / 2, length / 2);
        } else {
            if (arr[x][y] == 0) {
                zeroValueCount++;
            } else {
                oneValueCount++;
            }
        }

    }

    private boolean checked(int[][] arr, int x, int y, int length) {
        int firstValue = arr[x][y];
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[i][j] != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }
}