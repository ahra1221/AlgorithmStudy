import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        for(int i=1;i<=n;i++) {
            if(!visited[i]) {
                queue.offer(i);
                visited[i] = true;
                answer++;
                
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    for(int nxt = 1; nxt <= n; nxt++) {
                        if(i != nxt && computers[cur-1][nxt-1] == 1 && !visited[nxt]) {
                            queue.offer(nxt);
                            visited[nxt] = true;
                        } 
                    }
                }
            }
        }
        
        return answer;
    }
}