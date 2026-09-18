import java.io.*;
import java.util.*;

class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			long N = Long.parseLong(br.readLine());
			int answer = 0;
			
			while(N != 2) {
				long sqrt = (long) Math.sqrt(N);
				
				if(sqrt * sqrt == N) {
					N = sqrt;
					answer++;
				} else {
					long nxt = (sqrt+1) * (sqrt+1);
					answer += nxt - N;
					N = nxt;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
}
