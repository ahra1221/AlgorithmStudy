import java.util.*;

public class Main {

    static int n;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int total = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i,j);
                    list.add(size);
                    total++;
                }
            }
        }

        System.out.println(total);
        Collections.sort(list);
        for(int l: list) System.out.println(l);

    }

    static int dfs(int x, int y) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        int count = 1;
        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(grid[nx][ny] == 0) continue;  
            if(visited[nx][ny]) continue;
            count += dfs(nx,ny);
        }
        return count;
    }
}