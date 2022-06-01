import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
		LinkedList<Integer> truckQ = new LinkedList<>();
		for (int i = 0; i < truck_weights.length; i++) {
			truckQ.offer(truck_weights[i]);
		}

		LinkedList<Integer> bridgeQ = new LinkedList<>();
		for (int i = 0; i < bridge_length; i++) {
			bridgeQ.offer(0);
		}

		while (!truckQ.isEmpty()) {
			answer++;
			Integer truckPoll = truckQ.poll();

			if (bridgeQ.getFirst() != 0) {
				weight += bridgeQ.getFirst();
			}

			if (weight - truckPoll >= 0) {
				weight -= truckPoll;

				bridgeQ.poll();
				bridgeQ.addLast(truckPoll);

			} else {
				truckQ.addFirst(truckPoll);
				bridgeQ.poll();
				bridgeQ.addLast(0);
			}
		}

		answer += bridge_length;

		return answer;
    }
}