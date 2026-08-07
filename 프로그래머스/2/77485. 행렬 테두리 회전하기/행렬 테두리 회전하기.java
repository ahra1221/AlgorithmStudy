class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int n = 1;
        for(int r=0;r<rows;r++) {
            for(int c=0;c<columns;c++){
                arr[r][c] = n++;
            }
        }
        
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int idx = 0;
        
        for(int[] query: queries) {
            int sx = query[0]-1, sy = query[1]-1;
            int ex = query[2]-1, ey = query[3]-1;
            int before = arr[sx][sy];
            int minVal = before;
            int d = 0;
            
            while(true) {
                int nx = sx + dx[d];
                int ny = sy + dy[d];
                if(nx < query[0]-1 || nx > ex || ny < query[1]-1 || ny > ey) {
                    d = (d+1) % 4;
                    if(d == 0) {
                        break;
                    }
                    nx = sx + dx[d];
                    ny = sy + dy[d];
                }
                int next = arr[nx][ny];
                arr[nx][ny] = before;
                before = next;
                minVal = Math.min(minVal, before);
                
                sx = nx;
                sy = ny;
            }
            answer[idx++] = minVal;
        }
        
        return answer;
    }
}