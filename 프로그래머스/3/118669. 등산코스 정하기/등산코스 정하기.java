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
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        HashMap<Integer,ArrayList<Node>> map = new HashMap<>();
        for(int[] path: paths) {
            int i = path[0], j = path[1], w = path[2];
            map.computeIfAbsent(i, k -> new ArrayList<>()).add(new Node(j,w));
            map.computeIfAbsent(j, k -> new ArrayList<>()).add(new Node(i,w));
        }
        
        boolean[] isSummit = new boolean[n+1];
        for(int summit: summits) {
            isSummit[summit] = true;
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost); 
        boolean[] isGate = new boolean[n+1];
        for(int gate: gates) {
            pq.offer(new Node(gate,0));
            dist[gate] = 0;
            isGate[gate] = true;
        }
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dist[cur.node]) continue;
            if(isSummit[cur.node]) continue;
            for(Node nxt: map.getOrDefault(cur.node, new ArrayList<>())) {
                if(isGate[nxt.node]) continue;
                int newCost = Math.max(nxt.cost, dist[cur.node]);
                if(newCost >= dist[nxt.node]) continue;
                pq.offer(new Node(nxt.node, newCost));
                dist[nxt.node] = newCost;   
            }
        }
        
        int[] answer = new int[2];
        int intensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for(int summit: summits) {
            if(dist[summit] < intensity) {
                intensity = dist[summit];
                answer = new int[]{summit, intensity};
            }
        }
        
        return answer;
    }
}