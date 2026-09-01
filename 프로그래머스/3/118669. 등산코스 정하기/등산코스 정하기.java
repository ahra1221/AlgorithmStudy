import java.util.*;

class Solution {
    
    class Node {
        int end;
        int dis;
        
        Node(int end, int dis) {
            this.end = end;
            this.dis = dis;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
        for(int[] path: paths) {
            int st = path[0], en = path[1], d = path[2];
            map.computeIfAbsent(st, k->new ArrayList<>()).add(new Node(en,d));
            map.computeIfAbsent(en, k->new ArrayList<>()).add(new Node(st,d));
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        boolean[] isGate = new boolean[n+1];
        for(int gate: gates) {
            pq.offer(new Node(gate,0));
            dist[gate] = 0;
            isGate[gate] = true;
        }
        
        boolean[] isSummit = new boolean[n+1];
        for(int summit: summits) {
            isSummit[summit] = true;
        }
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.dis > dist[cur.end]) continue;
            if(isSummit[cur.end]) continue;
            for(Node node: map.getOrDefault(cur.end, new ArrayList<>())) {
                if(isGate[node.end]) continue;
                int newDis = Math.max(dist[cur.end], node.dis);
                if(newDis < dist[node.end]) {
                    pq.offer(new Node(node.end, newDis));
                    dist[node.end] = newDis;
                }
            }
        }
        
        int val = Integer.MAX_VALUE;
        int num = Integer.MAX_VALUE;
        for(int summit: summits) {
            if(dist[summit] < val || (dist[summit] == val && summit < num)) {
                num = summit;
                val = dist[summit];
            }
        }
        
        return new int[]{num, val};
    }
}