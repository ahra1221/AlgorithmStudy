import java.util.*;

class Solution {
    
    class Point {
        int x;
        int y;
        int cnt;
        
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public int solution(String[] board) {
        int r = board.length;
        int c = board[0].length();
        
        Point start = new Point(0,0,0);
        Point end = new Point(0,0,0);
        Character[][] map = new Character[r][c];
        
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                char ch = board[i].charAt(j);
                if(ch == 'R') start = new Point(i,j,0);
                if(ch == 'G') end = new Point(i,j,0);
                map[i][j] = ch;
            }
        }
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        queue.offer(start);
        visited[start.x][start.y] = true;
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.x == end.x && cur.y == end.y) {
                return cur.cnt;
            }
            
            for(int i=0;i<4;i++) {
                int nx = cur.x, ny = cur.y, nc = cur.cnt;
                while(true) {
                    int tmpx = nx + dx[i];
                    int tmpy = ny + dy[i];
                    if(tmpx < 0 || tmpx >= r || tmpy < 0 || tmpy >= c) break;
                    if(map[tmpx][tmpy] == 'D') break;
                    nx = tmpx;
                    ny = tmpy;
                }
                
                if(visited[nx][ny]) continue;
                queue.offer(new Point(nx,ny,nc+1));
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}