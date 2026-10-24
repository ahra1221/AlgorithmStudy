import java.util.*;

class Solution {
    
    int[] number;
    int[] selected = new int[3];
    int answer = 0;
    
    public int solution(int[] number) {
        this.number = number;
        dfs(0,0);
        return answer;
    }
    
    void dfs(int start, int depth) {
        if(depth == 3) {
            int sum = 0;
            for(int s: selected) {
                sum += s;
            }
            if(sum == 0) answer++;
            return;
        }
        
        for(int i=start;i<number.length;i++) {
            selected[depth] = number[i];
            dfs(i+1, depth+1);
        }
    }
}