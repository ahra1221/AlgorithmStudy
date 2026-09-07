import java.util.Scanner;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int total;
    static int areaCount;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int total = 0;
        int areaCount = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    areaCount = dfs(i,j,grid[i][j]);
                    if(areaCount >=4) {
                        total ++;
                    }
                    maxArea = Math.max(areaCount, maxArea);
                }
            }
        }
        System.out.println(total + " " + maxArea);
    }

    static int dfs(int x, int y, int num) {
        visited[x][y] = true;
        int cnt = 1;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(grid[nx][ny] != num || visited[nx][ny]) continue;
            
            cnt += dfs(nx,ny,num);
        }
        return cnt;
    }
}