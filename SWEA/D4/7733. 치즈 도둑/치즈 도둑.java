import java.io.*;
import java.util.*;

class Solution {
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int maxDay;
	static int[][] cheese;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	
	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, cheese[i][j]);
				}
			}
			
			int maxCount = 0;
			for(int day = 0; day <= maxDay; day++) {
				visited = new boolean[N][N];
				int count = 0;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if (visited[i][j]) continue;
						
						visited[i][j] = true;
						if(cheese[i][j] > day) {
							count++;
							bfs(new Point(i, j), day);
						}
					}
				}
				maxCount = Math.max(maxCount, count);
			}
			sb.append("#").append(test_case).append(" ").append(maxCount).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(Point start, int day) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(visited[nx][ny] || cheese[nx][ny] <= day) continue;
				
				visited[nx][ny] = true;
				queue.add(new Point(nx,ny));
			}
		}
	}

}
