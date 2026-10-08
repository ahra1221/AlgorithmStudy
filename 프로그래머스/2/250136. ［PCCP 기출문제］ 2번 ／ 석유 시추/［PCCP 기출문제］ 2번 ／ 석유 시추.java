import java.util.*;

class Solution {
    
    class Point{ 
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] land;
    int n, m;
    boolean[][] visited;
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    Set<Integer> cols;
    int areaCnt;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        this.land = land;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        
        int[] total = new int[m+1];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(new Point(i,j));
                    for(int col: cols) {
                        total[col] += areaCnt;
                    }
                }
            }
        }
        
        for(int x: total) {
            answer = Math.max(answer, x);
        }
        
        return answer;
    }
    
    void bfs(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        
        cols = new HashSet<>();
        cols.add(start.y+1);
        areaCnt = 1;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int d=0;d<4;d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(visited[nx][ny] || land[nx][ny] == 0) continue;
                
                q.offer(new Point(nx,ny));
                visited[nx][ny] = true;
                cols.add(ny+1);
                areaCnt++;
            }
        }
    }
}