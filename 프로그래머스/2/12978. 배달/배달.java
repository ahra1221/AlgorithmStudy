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
    
    public int solution(int N, int[][] road, int K) {
        HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int[] r: road) {
            int a = r[0], b = r[1], d = r[2];
            map.computeIfAbsent(a, k->new ArrayList<>()).add(new Node(b,d));
            map.computeIfAbsent(b, k->new ArrayList<>()).add(new Node(a,d));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        pq.offer(new Node(1,0));
        dist[1] = 0;
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dist[cur.node]) continue;
            for(Node nxt: map.get(cur.node)) {
                int nxtCost = nxt.cost + cur.cost;
                if(nxtCost < dist[nxt.node]) {
                    dist[nxt.node] = nxtCost;
                    pq.offer(new Node(nxt.node,nxtCost));
                }
            }
        }
        int answer = 0;
        for(int d: dist) {
            if(d <= K) answer++;
        }
        return answer;
    }
}