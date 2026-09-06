import java.util.Scanner;
public class Main {

    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n][m];
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        int answer = dfs(0,0);
        System.out.println(answer);
    }

    static int dfs(int x, int y) {
        if(x == n-1 && y == m-1) {
            return 1;
        }
        int[] dx = {1,0};
        int[] dy = {0,1};

        visited[x][y] = true;

        for(int i=0;i<2;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            if(grid[nx][ny] == 0) continue;
            if(visited[nx][ny]) continue;
            if(dfs(nx,ny) == 1) return 1;
        }
        return 0;
    }
}