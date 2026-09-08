import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int answer;
	static int N, M;
	static ArrayList<Integer>[] badBurger;
	static boolean[] make;
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer = 0;
			badBurger = new ArrayList[N+1];
            for (int i=1; i<=N; i++) {
            	badBurger[i] = new ArrayList<>();
            }
            
            make = new boolean[N+1];
			for(int m=0;m<M;m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				badBurger[a].add(b);
				badBurger[b].add(a);
			}
			dfs(1);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if(depth == N+1) {
			answer++;
			return;
		}
		
		boolean canMake = true;
		for(int bur: badBurger[depth]) {
			if(make[bur]) {
				canMake = false;
				break;
			}
		}
		
		if(canMake) {
			make[depth] = true;
			dfs(depth+1);
			make[depth] = false;
		}
		dfs(depth+1);
	}
	
}