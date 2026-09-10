import java.io.*;
import java.util.*;

class Solution {
	
    public static void main(String[] args) throws Exception {

    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
        	int N = sc.nextInt();
        	
        	int[] tree = new int[N];
            for(int i=0;i<N;i++) {
            	tree[i] = sc.nextInt();
            }
            
            int idx = 0;
            int answer = 0;
            
            while(idx < N-2) {
            	int i = idx;
            	int k = i;
            	while(k < N-1 && tree[k] < tree[k+1]) k++;
            	if(i==k) {
            		idx++;
            		continue;
            	}
            	
            	int j = k;
            	while(j < N-1 && tree[j] > tree[j+1]) j++;
            	
            	answer += (k-i) * (j-k);
            	idx = j;
            }
            
            sb.append("#")
              .append(tc)
              .append(" ")
              .append(answer)
              .append("\n");
        }

        System.out.print(sb);
    }
}