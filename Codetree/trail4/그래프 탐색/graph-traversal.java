import java.util.*;
public class Main {

    static Map<Integer,ArrayList<Integer>> graph = new HashMap<>();
    static int n;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n+1];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        visited[1] = true;
        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int cur) {
        for(int nxt: graph.getOrDefault(cur, new ArrayList<>())) {
            if(!visited[nxt]) {
                visited[nxt] = true;
                cnt++;
                dfs(nxt);
            }
        }
    }
}