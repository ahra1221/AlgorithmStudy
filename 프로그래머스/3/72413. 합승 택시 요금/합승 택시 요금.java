import java.util.*;

class Solution {
    
    class Node {
        int node;
        int cost;
        
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    
    static HashMap<Integer,ArrayList<Node>> map = new HashMap<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        for(int[] fare: fares) {
            int c = fare[0], d = fare[1], f = fare[2];
            map.computeIfAbsent(c, k -> new ArrayList<>()).add(new Node(d,f));
            map.computeIfAbsent(d, k -> new ArrayList<>()).add(new Node(c,f));
        }
        
        int[] distS = dijkstra(n,s);
        int[] distA = dijkstra(n,a);
        int[] distB = dijkstra(n,b);
        for(int i=1;i<=n;i++) {
            int total = distS[i] + distA[i] + distB[i];
            answer = Math.min(answer,total);
        }
        
        return answer;
    }
    
    int[] dijkstra(int n, int st) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new Node(st,0));
        dist[st] = 0;
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for(Node next: map.getOrDefault(cur.node, new ArrayList<>())) {
                int nextCost = cur.cost + next.cost;
                if(nextCost > dist[next.node]) continue;
                pq.offer(new Node(next.node, nextCost));
                dist[next.node] = nextCost;
            }
        }
        return dist;
    }
}