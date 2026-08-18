import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int r = board.length, c = board[0].length();
        int[] start = new int[2];
        char[][] map = new char[r][c];
        for(int i=0;i<r;i++) {
            char[] ch = board[i].toCharArray();
            for(int j=0;j<c;j++) {
                char tmp = ch[j];
                if (tmp == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                map[i][j] = tmp;
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        queue.offer(new int[]{start[0], start[1],0});
        visited[start[0]][start[1]] = true;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], cnt = cur[2];
            if(map[x][y] == 'G') {
                answer = cnt;
                break;
            }
            for(int d=0;d<4;d++) {
                int cx = x, cy = y;
                while(true) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if(nx < 0 || nx >= r || ny < 0 || ny >= c) break;
                    if(map[nx][ny] == 'D') break;
                    cx = nx;
                    cy = ny;
                }
                
                if(!visited[cx][cy]) {
                    queue.offer(new int[]{cx,cy,cnt+1});
                    visited[cx][cy] = true;
                }
            }
        }
        
        return answer;
    }
}   