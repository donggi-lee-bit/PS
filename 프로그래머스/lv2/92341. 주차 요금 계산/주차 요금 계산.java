import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> cars = new HashMap<>();
        List<String> carNumbers = new ArrayList<>();
        for (String record : records) {
            String[] split = record.split(" ");
            int time = convertTime(split[0]);
            String carNumber = split[1];
            String inOrOut = split[2];
            if (cars.get(carNumber) == null) {
                cars.put(carNumber, -time);
                carNumbers.add(carNumber);
            } else {
                if (inOrOut.equals("IN")) {
                    int findTime = cars.get(carNumber);
                    cars.put(carNumber, findTime - time);
                } else {
                    int findTime = cars.get(carNumber);
                    cars.put(carNumber, findTime + time);
                }
            }
        }

        for (Entry<String, Integer> entry : cars.entrySet()) {
            int value = entry.getValue();
            if (value < 0) {
                if (value == -1) {
                    value = 0;
                }
                int convertTime = convertTime("23:59");
                String key = entry.getKey();
                cars.put(key, value + convertTime);
            }
        }

        Collections.sort(carNumbers);

        int[] answer = new int[cars.size()];
        int index = 0;
        for (String carNumber : carNumbers) {
            int findTime = cars.get(carNumber);
            answer[index] = calculate(findTime, fees);
            index++;
        }
        return answer;
    }

    private int calculate(int findTime, int[] fees) {
        if (findTime > fees[0]) {
            return ((findTime - fees[0]) % fees[2]) != 0
                ? fees[1] + ((findTime - fees[0]) / fees[2]) * fees[3] + fees[3]
                : fees[1] + ((findTime - fees[0]) / fees[2]) * fees[3];
        } else {
            return fees[1];
        }
    }

    private int convertTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        if (Integer.parseInt(hour) == 0 && Integer.parseInt(minute) == 0) {
            return 1;
        }
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }

}
