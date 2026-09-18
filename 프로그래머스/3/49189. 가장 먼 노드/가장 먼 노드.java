import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
        
        for(int[] vertex: edge) {
            int a = vertex[0];
            int b = vertex[1];
            graph.computeIfAbsent(a, k->new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k->new ArrayList<>()).add(a);
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        int[] moves = new int[n+1];
        int maxDis = 0;
        
        queue.offer(1);
        visited[1] = true;
        moves[1] = 1;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int move = moves[cur];
            for(int nxt: graph.getOrDefault(cur, new ArrayList<>())) {
                if(visited[nxt]) continue;
                queue.offer(nxt);
                visited[nxt] = true;
                moves[nxt] = move+1;
                maxDis = Math.max(maxDis, moves[nxt]);
            }
        }
        
        int answer = 0;
        for(int move: moves) {
            if(move == maxDis) answer++;
        }
        return answer;
    }
}