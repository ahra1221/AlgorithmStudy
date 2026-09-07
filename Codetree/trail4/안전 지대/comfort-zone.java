import java.util.Scanner;
public class Main {

    static int n;
    static int m;
    static int maxRain = 0;
    static int[][] grid;
    static boolean[][] visited;
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                maxRain = Math.max(maxRain, grid[i][j]);
            }
        }

        int ansK = 1;
        int maxArea = 0;
        for(int k=1;k<=maxRain;k++) {
            visited = new boolean[n][m];
            int area = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(grid[i][j] > k && !visited[i][j]) {
                        area++;
                        dfs(i,j,k);
                    }
                }
            }
            if(maxArea < area) {
                ansK = k;
                maxArea = area;
            }
        }
        System.out.println(ansK + " " + maxArea);
    }

    static void dfs(int x, int y, int k) {
        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            if(grid[nx][ny] <= k) continue;
            if(visited[nx][ny]) continue;
            dfs(nx,ny,k);   
        }
    }
}