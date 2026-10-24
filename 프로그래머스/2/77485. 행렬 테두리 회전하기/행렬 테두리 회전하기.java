class Solution {
    
    int[][] map;
    int[] minVal;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        minVal = new int[queries.length];
        
        int n = 1;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<columns;j++) {
                map[i][j] = n++;
            }   
        }
        
        int idx = 0;
        for(int[] query: queries) {
            minVal[idx++] = rotate(query[0]-1, query[1]-1, query[2]-1, query[3]-1);
        }
        return minVal;
    }
    
    int rotate(int x1, int y1, int x2, int y2) {
        int min = map[x1][y1];
        
        int tmp = map[x1][y1];
        int nx = x1;
        int ny = y1;
        // right
        while(ny < y2) {
            int nxt = map[x1][ny];
            map[x1][ny] = tmp;
            tmp = nxt;
            ny++;
            min = Math.min(min, nxt);
        }
        // down
        while(nx < x2) {
            int nxt = map[nx][y2];
            map[nx][y2] = tmp;
            tmp = nxt;
            nx++;
            min = Math.min(min, nxt);
        }
        // left
        while(ny > y1) {
            int nxt = map[x2][ny];
            map[x2][ny] = tmp;
            tmp = nxt;
            ny--;
            min = Math.min(min, nxt);
        }
        //up
         while(nx >= x1) {
            int nxt = map[nx][y1];
            map[nx][y1] = tmp;
            tmp = nxt;
            nx--;
            min = Math.min(min, nxt);
        }
        return min;
    }
}