import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String args[]) throws Exception {
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] buildings = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			int answer = 0;
			for(int i=2;i<N-2;i++) {
				int center = buildings[i];
				int left = Math.max(buildings[i-1], buildings[i-2]);
				int right = Math.max(buildings[i+1], buildings[i+2]);
				
				if(center > left && center > right) { // 조망권확보됨
					answer += center - Math.max(left, right);
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");

		}
		
		System.out.print(sb);
	}
}
