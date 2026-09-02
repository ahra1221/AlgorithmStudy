import java.util.*;

class Solution {
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 100_000_000;
        int answer = INF;
        
        int[][] dist = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
        
        for(int[] fare: fares) {
            int from = fare[0], to = fare[1], cost = fare[2];
            dist[from][to] = Math.min(dist[from][to], cost);
            dist[to][from] = Math.min(dist[to][from], cost);
        }
        
        // 플로이드워셜
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    dist[i][j] = Math.min(
                        dist[i][j],
                        dist[i][k] + dist[k][j]
                    );
                }
            }
        }
        
        for(int k=1;k<=n;k++) {
            answer = Math.min(
                answer,
                dist[s][k]+dist[k][a]+dist[k][b]
            );
        }
        return answer;
    }
}