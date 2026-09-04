import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int answer;
	static boolean[] visited;
	static int[] gyuyoung;
	static int[] inyoung;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			answer = 0;
			gyuyoung = new int[9];
			inyoung = new int[9];
			st = new StringTokenizer(br.readLine());
			boolean[] used = new boolean[19];
			for(int i=0;i<9;i++) {
				gyuyoung[i] = Integer.parseInt(st.nextToken());
				used[gyuyoung[i]] = true;
			}
			
			int idx = 0;
			for(int i=1;i<=18;i++) {
				if(!used[i]) {
					inyoung[idx++] = i;
				}
			}
			visited = new boolean[9];
			backtracking(0,0,0);
			sb.append("#").append(test_case).append(" ").append(answer).append(" ").append(factorial(9) - answer).append("\n");
		}
		System.out.println(sb);
	}

	static void backtracking(int depth, int gyu, int in) {
		if(depth == 9) {
			if(gyu > in) answer++;
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			int sum = gyuyoung[depth] + inyoung[i];
			if(gyuyoung[depth] > inyoung[i]) {
				backtracking(depth+1, gyu + sum, in);
			} else {
				backtracking(depth+1, gyu, in+sum);
			}
			visited[i] = false;
		}
	}
	
	static int factorial(int n) {
	    if (n == 0 || n == 1) {
	        return 1;
	    }
	    return n * factorial(n - 1);
	}
}
