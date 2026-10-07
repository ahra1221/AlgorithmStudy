import java.util.*;

class Solution {
    
    class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int n, m;
    char[][] container;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        
        container = new char[n][m];
        for(int i=0;i<n;i++) {
            char[] ch = storage[i].toCharArray();
            for(int j=0;j<m;j++) {
                container[i][j] = ch[j];
            }
        }
        
        for(String req: requests) {
            if(req.length() == 1) { // 지게차
                bfs(req.charAt(0));
            } else { // 크레인
                for(int i=0;i<n;i++) {
                    for(int j=0;j<m;j++) {
                        if(container[i][j] != req.charAt(0)) continue;
                        container[i][j] = ' ';
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(container[i][j] != ' ') answer++;
            }
        }
        return answer;
    }
    
    void bfs(char target) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        for(int j=0;j<m;j++) {
            q.offer(new Point(0,j));
            visited[0][j] = true;
        }
        for(int i=0;i<n;i++) {
            q.offer(new Point(i,m-1));
            visited[i][m-1] = true;
        }
        for(int j=m-1;j>=0;j--) {
            q.offer(new Point(n-1,j));
            visited[n-1][j] = true;
        }
        for(int i=n-1;i>=0;i--) {
            q.offer(new Point(i,0));
            visited[i][0] = true;
        }
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            if(container[cur.x][cur.y] == target) {
                container[cur.x][cur.y] = ' ';
                continue;
            } else if(container[cur.x][cur.y] == ' ') {
                for(int d=0;d<4;d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];
                    if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                    if(visited[nx][ny]) continue;
                    if(container[nx][ny] == ' ' || container[nx][ny] == target) {
                        q.offer(new Point(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
    }
}