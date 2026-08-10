import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, String> cars = new HashMap<>();
        Map<Integer, Integer> carTime = new HashMap<>();
        for(String record: records) {
            String[] tmp = record.split(" ");
            int carNumber = Integer.parseInt(tmp[1]);
            if(tmp[2].equals("IN")) {
                cars.put(carNumber, tmp[0]);
            } else{
                int[] inTime = splitTime(cars.get(carNumber));
                cars.remove(carNumber);
                int[] outTime = splitTime(tmp[0]);
                int totalTime = calMinute(inTime[0], inTime[1], outTime[0], outTime[1]);
                carTime.put(carNumber, carTime.getOrDefault(carNumber, 0) + totalTime);
            }
        }
        
        for(Integer key: cars.keySet()) {
            int[] inTime = splitTime(cars.get(key));
            int totalTime = calMinute(inTime[0], inTime[1], 23, 59);
            carTime.put(key, carTime.getOrDefault(key, 0) + totalTime);
        }
        
        List<Integer> keyList = new ArrayList<>(carTime.keySet());
        keyList.sort((s1,s2) -> s1.compareTo(s2));
        for(Integer key: keyList) {
            answer.add(calFee(carTime.get(key), fees));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int calMinute(int h1, int m1, int h2, int m2) {
        return h2 * 60 + m2 - h1 * 60 - m1;
    }
    
    public static int[] splitTime(String time) {
        String[] arr = time.split(":");
        int[] ans = {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
        return ans;
    }
    
    public static int calFee(int total, int[] fees) {
        int fee = fees[1];
        if(total > fees[0]) {
            fee += Math.ceil((double)(total-fees[0]) / (double)fees[2]) * fees[3];
        }
        return fee;
    }
}