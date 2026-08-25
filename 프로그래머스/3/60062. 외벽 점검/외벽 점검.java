import java.util.*;

class Solution {
    
    List<int[]> permutations = new ArrayList<>();
    int[] order;
    boolean[] visited;
    
    public int solution(int n, int[] weak, int[] dist) {
        int answer = Integer.MAX_VALUE;
        
        int len = weak.length;
        int[] line = new int[len * 2];
        for(int i=0;i<len;i++) {
            line[i] = weak[i];
            line[i+len] = weak[i]+n;
        }
        
        order = new int[dist.length];
        visited = new boolean[dist.length];
        permutation(0,dist);
        
        for(int st=0;st<len;st++) {
            for(int[] per: permutations) {
                int idx = st;
                for(int i=0;i<per.length;i++) {
                    int end = line[idx] + per[i];
                    while(idx < st + len && line[idx] <= end) idx++;
                    
                    if(idx >= st + len) { // weak 커버
                        answer = Math.min(answer, i+1);
                    }
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
     void permutation(int depth, int[] dist) {

        if (depth == dist.length) {
            permutations.add(order.clone());
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            order[depth] = dist[i];
            permutation(depth + 1, dist);
            visited[i] = false;
        }
    }
}