import java.util.*;

class Solution {
    
    String[][] miro;
    int n, m;
    
    public int solution(String[] maps) {
        int answer = 0;
        int[] sPoint = new int[2];
        int[] lPoint = new int[2];
        int[] ePoint = new int[2];
        
        n = maps.length;
        m = maps[0].length();
        miro = new String[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                String[] tmp = maps[i].split("");
                miro[i][j] = tmp[j];
                if(tmp[j].equals("S")) {
                    sPoint[0] = i;
                    sPoint[1] = j;
                }else if(tmp[j].equals("L")) {
                    lPoint[0] = i;
                    lPoint[1] = j;
                }else if(tmp[j].equals("E")) {
                    ePoint[0] = i;
                    ePoint[1] = j;
                }
            }
        }
        
        int sToL = bfs(sPoint[0], sPoint[1], lPoint[0], lPoint[1]);
        if (sToL < 0) {
            return -1;
        } else {
            int lToE = bfs(lPoint[0], lPoint[1], ePoint[0], ePoint[1]);
            if(lToE < 0) {
                return -1;
            } else {
                return sToL + lToE;
            }
        }
    }
    
    int bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        queue.offer(new int[]{sx,sy,0});
        visited[sx][sy] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dis = cur[2];
            
            if(x == ex && y == ey) {
                return dis;
            }
            
            for(int d=0;d<4;d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(miro[nx][ny].equals("X")) continue;
                if(visited[nx][ny]) continue;
                
                queue.offer(new int[]{nx,ny,dis+1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}