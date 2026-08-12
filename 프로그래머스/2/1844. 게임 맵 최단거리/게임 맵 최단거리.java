import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for(int i=0;i<4;i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maps[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
                maps[nx][ny] = maps[x][y] + 1;
            }
        }
        
        if(!visited[n-1][m-1]) {
            return -1;
        } else {
            return maps[n-1][m-1];
        }
    }
} 