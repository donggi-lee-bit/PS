class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            }

            if (number % 3 == 0) {
                sb.append('R');
                right = number;
            } else if (number % 3 == 1) {
                sb.append('L');
                left = number;
            } else {
                int leftDist = ((Math.abs(left - number)) / 3) + ((Math.abs(left - number)) % 3);
                int rightDist = ((Math.abs(right - number)) / 3) + ((Math.abs(right - number)) % 3);

                if (leftDist < rightDist) {
                    sb.append('L');
                    left = number;
                } else if (leftDist > rightDist) {
                    sb.append('R');
                    right = number;
                } else {
                    if (hand.equals("right")) {
                        sb.append('R');
                        right = number;
                    } else {
                        sb.append('L');
                        left = number;
                    }
                }
            }
        }

        return sb.toString();
    }
}