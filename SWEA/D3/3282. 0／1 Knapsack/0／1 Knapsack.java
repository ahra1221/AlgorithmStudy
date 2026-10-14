import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String args[]) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[K+1];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int V = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				
				for(int j=K; j>= V; j--) {
					dp[j] = Math.max(dp[j], dp[j-V] + C);
				}
			}
			
			
			sb.append("#").append(test_case).append(" ").append(dp[K]).append("\n");

		}
		
		System.out.print(sb);
	}

}
