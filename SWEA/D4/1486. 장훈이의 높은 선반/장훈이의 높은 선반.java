import java.io.*;
import java.util.*;

class Solution {
	
	static int N;
	static int B;
	
	static int minHeight = 0;
	static int[] height;
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            height = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
            	height[i] = Integer.parseInt(st.nextToken());
            	minHeight += height[i];
            }
            
            backtracking(0,0);
            
            sb.append("#")
              .append(tc)
              .append(" ")
              .append(minHeight - B)
              .append("\n");
        }

        System.out.print(sb);
    }
    
    static void backtracking(int idx, int tower) {
    	if(tower >= B) {
    		minHeight = Math.min(minHeight, tower);
    		return;
    	}
    	
    	if(tower >= minHeight || idx == N) return;
    	
    	for(int i=idx;i<N;i++) {
    		backtracking(i+1,tower+height[i]);
    	}
    }
}