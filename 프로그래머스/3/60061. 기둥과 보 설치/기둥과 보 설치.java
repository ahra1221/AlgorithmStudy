import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<int[]> answer = new ArrayList<>();
        boolean[][][] map = new boolean[n+1][n+1][2]; // 0이 기둥 1이 보
        for(int[] frame: build_frame) {
            int x = frame[0], y = frame[1], a = frame[2], b = frame[3];
            if(b == 0) { // 삭제
                map[x][y][a] = false;
                if(!isValid(n,map)) {
                    map[x][y][a] = true;
                }
            } else { // 설치
                map[x][y][a] = true;
                if (!(isValid(n,map))) {
                    map[x][y][a] = false;
                }
            }
        }
        
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                if(map[i][j][0]) {
                    answer.add(new int[]{i,j,0});
                }
                if(map[i][j][1]) {
                    answer.add(new int[]{i,j,1});
                }
            }
        }
        
        return answer.toArray(new int[answer.size()][]);
    }
    
    public static boolean isValidColumn(boolean[][][] frame, int x, int y) { // 기둥
        return y == 0 
            || (y > 0 && frame[x][y-1][0]) 
            || (x > 0 && frame[x-1][y][1])
            || frame[x][y][1];
    }
    
    public static boolean isValidRow(int n, boolean[][][] frame, int x, int y) { // 보
       return (y > 0 && frame[x][y-1][0])
            || (x < n && y > 0 && frame[x+1][y-1][0]) 
            || (x > 0 && x < n && frame[x-1][y][1] && frame[x+1][y][1]); 
    }
    
    public static boolean isValid(int n, boolean[][][] frame) {
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                if(frame[i][j][0] && !isValidColumn(frame,i,j)) return false;
                if(frame[i][j][1] && !isValidRow(n,frame,i,j)) return false;
            }
        }
        return true;
    }
}