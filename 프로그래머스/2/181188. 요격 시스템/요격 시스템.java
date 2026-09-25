import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> {
            return a[1] - b[1];
        });
        
        int en = -1;
        for(int[] target: targets) {
            if(target[0] >= en) {
                answer++;
                en = target[1];
            }
        }
        
        return answer;
    }
}