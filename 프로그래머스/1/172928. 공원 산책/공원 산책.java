class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int n = park.length;
        int m = park[0].length();
        
        char[][] map = new char[n][m];
        int x = 0, y = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        for(String route: routes) {
            String[] r = route.split(" ");
            int d = "SNEW".indexOf(r[0]);
            int nx = x, ny = y;
            int cnt = 1;
            boolean canMove = true;
            while(cnt <= Integer.parseInt(r[1])) {
                nx += dx[d];
                ny += dy[d];
                if(nx<0 || nx>=n || ny<0 || ny>= m || map[nx][ny] == 'X') {
                    canMove = false;
                    break;
                }
                cnt++;
            }
            if(canMove) {
                x = nx;
                y = ny;
            }
        }
        
        return new int[]{x,y};
    }
}