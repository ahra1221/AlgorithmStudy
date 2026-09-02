import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this==obj) return true;
			if(!(obj instanceof Point)) return false;
			
			Point other = (Point) obj;
			return this.x == other.x && this.y == other.y;
		}
	}

	public static void main(String[] args) throws Exception {
		int T = 10;
		int n = 16;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		for(int t=1;t<=T;t++) {
			int answer = 0;
			int tc = Integer.parseInt(br.readLine());
			
			Point start = new Point(0,0);
			Point end = new Point(0,0);
			int[][] miro = new int[n][n];
			for(int r=0;r<n;r++) {
				String line = br.readLine();
				for(int c=0;c<n;c++) {
					int v = line.charAt(c) - '0';
					miro[r][c] = v;
					if(v == 2) { // start
						start = new Point(r,c);
					} else if(v == 3) { // end
						end = new Point(r,c);
					}
				} 			
			}
			
			Queue<Point> queue = new ArrayDeque<>();
			boolean[][] visited = new boolean[n][n];
			queue.offer(start);
			visited[start.x][start.y] = true;
			
			//bfs
			while(!queue.isEmpty()) {
				Point cur = queue.poll();
				
				if(cur.equals(end)) {
					answer = 1;
					break;
				}
				
				for(int d=0;d<4;d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					if(miro[nx][ny] == 1) continue;
					if(visited[nx][ny]) continue;
					
					queue.offer(new Point(nx,ny));
					visited[nx][ny] = true;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}

}