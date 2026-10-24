import java.util.*;

class Solution {
    
    class Priority {
        int loc;
        int p;
        
        Priority(int loc, int p) {
            this.loc = loc;
            this.p = p;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Priority> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<priorities.length;i++) {
            q.offer(new Priority(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            Priority cur = q.poll();
            if(cur.p < pq.peek()) {
                q.offer(cur);
                continue;
            }
            pq.poll();
            answer++;
            if(cur.loc == location) {
                return answer;
            }
        }
        return answer;
    }
}