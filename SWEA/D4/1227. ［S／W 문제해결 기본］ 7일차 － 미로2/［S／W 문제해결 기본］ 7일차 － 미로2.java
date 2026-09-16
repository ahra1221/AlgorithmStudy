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
		
		@Override
		public boolean equals(Object obj) {
		    Point p = (Point) obj;
		    return this.x == p.x && this.y == p.y;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N = 100;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String args[]) throws Exception {
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			int[][] miro = new int[N][N];
			
			Point start = new Point(0,0);
			Point end = new Point(0,0);
			
			for(int i=0;i<N;i++) {
				String line = br.readLine();
				for(int j=0;j<N;j++) {
					miro[i][j] = line.charAt(j) - '0';
					if(miro[i][j] == 2) { // 출발
						start = new Point(i,j);
					} else if(miro[i][j] == 3) { // 도착
						end = new Point(i,j);
					}
				}
			}
			
			Queue<Point> queue = new ArrayDeque<>();
			boolean[][] visited = new boolean[N][N];
			queue.add(start);
			visited[start.x][start.y] = true;
			
			int answer = 0;
			while(!queue.isEmpty()) {
				Point cur = queue.poll();
				if(cur.equals(end)) {
					answer = 1;
					break;
				}
				
				for(int i=0;i<4;i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(visited[nx][ny] || miro[nx][ny] == 1) continue;
					
					visited[nx][ny] = true;
					queue.add(new Point(nx,ny));
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}
