import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothe = new HashMap<>();
        for(String[] clo: clothes) {
            clothe.put(clo[1], clothe.getOrDefault(clo[1], 0) + 1);
        }
        for(int val: clothe.values()) {
            answer *= (val + 1);
        }
        return answer-1;
    }
}