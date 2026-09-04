import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		// 위 아래 왼 오
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		char[] dirs = {'^', 'v', '<', '>'};
		Map<Character, Integer> dirMap = new HashMap<>();
		dirMap.put('^', 0);
		dirMap.put('v', 1);
		dirMap.put('<', 2);
		dirMap.put('>', 3);
		
		Map<Character, Integer> cmdMap = new HashMap<>();
		cmdMap.put('U', 0);
		cmdMap.put('D', 1);
		cmdMap.put('L', 2);
		cmdMap.put('R', 3);
		
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			int d = 0;
			int x = 0, y = 0;
			for(int h=0;h<H;h++) {
				String line = br.readLine();
				for(int w=0;w<W;w++) {
					char c = line.charAt(w);
					map[h][w] = c;
					if (dirMap.containsKey(c)) {
					    d = dirMap.get(c);
					    x = h;
					    y = w;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String command = br.readLine();
			for(char cmd: command.toCharArray()) {
				if(cmd == 'S') {
					int sx = x, sy = y;
					while(true) {
						sx += dx[d];
						sy += dy[d];
						if(sx<0 || sx>=H || sy<0 || sy>=W) break;
						if(map[sx][sy] == '*') { // 벽돌이면
							map[sx][sy] = '.';
							break;
						} else if(map[sx][sy] == '#') { // 강철이면
							break;
						}
					}
				} else {
					d = cmdMap.get(cmd);
					int nx = x + dx[d], ny = y + dy[d];
					if(nx<0 || nx>=H || ny<0 || ny>=W) {
						map[x][y] = dirs[d];
						continue;
					}
					if(map[nx][ny] != '.') {
						map[x][y] = dirs[d];
						continue;
					}
					map[x][y] = '.';
					map[nx][ny] = dirs[d];
					x = nx;
					y = ny;
				}
			}
			
			sb.append("#").append(test_case).append(" ");
			for(int h=0;h<H;h++) {
				for(int w=0;w<W;w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}