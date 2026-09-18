import java.util.*;

class Solution {
    
    static int N;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        N = n;
        Map<Integer, ArrayList<Integer>> winGraph = new HashMap<>();
        Map<Integer, ArrayList<Integer>> loseGraph = new HashMap<>();
        
        for(int[] result: results) {
            int win = result[0];
            int lose = result[1];
            winGraph.computeIfAbsent(win, k -> new ArrayList<>()).add(lose);
            loseGraph.computeIfAbsent(lose, k -> new ArrayList<>()).add(win);
        }
        
        for(int i=1;i<=n;i++) {
            int win = bfs(i, winGraph);
            int lose = bfs(i, loseGraph);
            if(win + lose == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static int bfs(int n, Map<Integer, ArrayList<Integer>> graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        queue.offer(n);
        visited[n] = true;
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int nxt: graph.getOrDefault(cur, new ArrayList<>())) {
                if(visited[nxt]) continue;
                visited[nxt] = true;
                queue.offer(nxt);
                cnt++;
            }
        }
        return cnt;
    }
}