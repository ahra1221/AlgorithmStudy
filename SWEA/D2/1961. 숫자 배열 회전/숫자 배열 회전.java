import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[][] map;
	static String[][] answer;
	
	public static void main(String args[]) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = new String[N][3];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(test_case).append("\n");
			for(int i=0;i<3;i++) {
				rotate90(i);
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<3;j++) {
					sb.append(answer[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb);
	}
	
	static void rotate90(int idx) {
		int[][] rotated = new int[N][N];
		int i = 0;
		for(int y=0;y<N;y++) {
			int j=0;
			for(int x=N-1;x>=0;x--) {
				rotated[i][j++] = map[x][y];
			}
			i++;
		}
		
		for(int r=0;r<N;r++) {
			String tmp = "";
			for(int c=0;c<N;c++) {
				tmp += rotated[r][c];
			}
			answer[r][idx] = tmp;
		}
		map = rotated;
	}
}
