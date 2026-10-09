import java.util.*;

class Solution {
    
    int n, k;
    int[][] reqs;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int k, int n, int[][] reqs) {
        this.n = n;
        this.k = k;
        this.reqs = reqs;
        dfs(new int[k], n, 0);
        return answer;
    }
    
    void dfs(int[] mentor, int left, int depth) {
        if(depth == k-1) {
            mentor[depth] = left;
            int waitTime = counsel(mentor);
            answer = Math.min(answer, waitTime);
            return;
        }
        
        for(int i=1;i<=left-1;i++) {
            mentor[depth] = i;
            dfs(mentor, left-i, depth+1);
        }
    }
    
    int counsel(int[] mentor) {
        int wait = 0;
        Map<Integer, PriorityQueue<Integer>> endTime = new HashMap<>();
        for(int[] req: reqs) {
            int a = req[0], b = req[1], c = req[2];
            
            PriorityQueue<Integer> pq = endTime.computeIfAbsent(c, k -> new PriorityQueue<>());
            
            if(pq.size() < mentor[c-1]) { // 멘토 남아있음
                pq.offer(a+b);
            } else {
                int earliest = pq.poll();
                if(earliest > a) {
                    wait += earliest - a;
                    pq.offer(earliest+b);
                } else {
                    pq.offer(a+b);
                }
            }
        }
        return wait;
    }
}