import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> subContainer = new ArrayDeque<>();
        
        int now = 1;
        for(int ord: order) {
            while(now <= ord) {
                subContainer.offerLast(now++);
            }
            
            if(subContainer.peekLast() == ord) {
                subContainer.pollLast();
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}