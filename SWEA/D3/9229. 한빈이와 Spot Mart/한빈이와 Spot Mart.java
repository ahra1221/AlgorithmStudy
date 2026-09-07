import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	
	static int answer;
	static int[] snack;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			answer = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0,0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int start, int count, int total) {
		if(count == 2) {
			if(total <= M) answer = Math.max(answer, total);
			return;
		}
		
		for(int i=start;i<N;i++) {
			dfs(i+1, count+1, total+snack[i]);
		}
	}
}