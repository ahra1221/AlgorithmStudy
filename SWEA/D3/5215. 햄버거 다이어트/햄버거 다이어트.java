import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int L;
	
	static int answer;
	static int[] scores;
	static int[] cals;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			scores = new int[N];
			cals = new int[N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				cals[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0,0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int start, int sc, int ca) {
		if(ca > L) return;
		
		answer = Math.max(answer, sc);
		
		for(int i=start;i<N;i++) {
			dfs(i+1, sc+scores[i], ca+cals[i]);
		}
	}
}