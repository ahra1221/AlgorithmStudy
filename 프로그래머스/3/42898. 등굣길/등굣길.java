import java.util.*;

class Solution {
    
    int[][] map;
    int n, m;
    boolean[][] blocked;
    
    public int solution(int m, int n, int[][] puddles) {
        this.n = n;
        this.m = m;
        map = new int[n][m];
        for(int[] r: map) {
            Arrays.fill(r, -1);
        }
        
        blocked = new boolean[n][m];
        for(int[] puddle: puddles) {
            blocked[puddle[1]-1][puddle[0]-1] = true;
        }
        return dp(0,0);
    }
    
    int dp(int r, int c) {
        if(r == n-1 && c == m-1) {
            return 1;
        }
        if(map[r][c] != -1) {
            return map[r][c];
        }
        
        int[] dx = {0,1};
        int[] dy = {1,0};
        int res = 0;
        for(int d=0;d<2;d++) {
            int nx = r+dx[d], ny = c+dy[d];
            if(nx<0 || nx >=n || ny<0 || ny>=m) continue;
            if(blocked[nx][ny]) continue;
            res = (res + dp(nx,ny)) % 1_000_000_007;
        }
        map[r][c] = res;
        return res;
    }
    
}