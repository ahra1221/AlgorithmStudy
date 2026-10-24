import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int n = 11;
        boolean[][][] visited = new boolean[n][n][4]; // 1상2하3좌4우
        
        int x = 5, y = 5;
        int[] reverse = {1, 0, 3, 2};
        int[] dx = {-1,1,0,0}; 
        int[] dy = {0,0,-1,1};
        for(char dir: dirs.toCharArray()) {
            int d = "UDLR".indexOf(dir);
            int nx = x + dx[d], ny = y + dy[d];
            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(!visited[x][y][d]) {
                answer++;
                visited[x][y][d] = true;
                visited[nx][ny][reverse[d]] = true;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
}