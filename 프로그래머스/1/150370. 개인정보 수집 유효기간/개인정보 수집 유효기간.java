import java.io.*;
import java.util.*;

class Solution {
    
    StringTokenizer st;
    HashMap<String, Integer> endTerm;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        endTerm = new HashMap<>();
        for(String term: terms) {
            String[] tmp = term.split(" ");
            endTerm.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        int idx = 1;
        for(String privacy: privacies) {
            String[] tmp = privacy.split(" ");
            int todayDay = calTerm(today, 0);
            int expireDay = calTerm(tmp[0], endTerm.get(tmp[1]));
            if(expireDay <= todayDay) {
                answer.add(idx);
            }
            idx++;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    int calTerm(String date, int term) {
        String[] days = date.split("\\.");
        int year = Integer.parseInt(days[0]);
        int month = Integer.parseInt(days[1]);
        int day = Integer.parseInt(days[2]);
        return year * 12 * 28 + month * 28 + day + term * 28;
    }
}