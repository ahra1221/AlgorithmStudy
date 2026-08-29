import java.util.*;

class Solution {
    
    static StringBuilder sb = new StringBuilder();
    
    public String solution(String number, int k) {
        String answer = "";
        Deque<Integer> dq = new ArrayDeque<>();
        for(char num: number.toCharArray()) {
            int n = num - '0';
            while(!dq.isEmpty() && dq.peekLast() < n && k > 0) {
                dq.pollLast();
                k--;
            }
            dq.addLast(n);
        }
        while(k>0) {
            dq.pollLast();
            k--;
        }
        
        for(int x: dq) {
            answer += x;
        }
        return answer;
    }
}