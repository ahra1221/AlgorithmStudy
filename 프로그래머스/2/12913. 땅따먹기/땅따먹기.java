import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = 4;
        
        int[][] dp = new int[n][m];
        dp[0] = land[0];
        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                int val = 0;
                for(int k=0;k<m;k++) {
                    if(j==k) continue;
                    val = Math.max(val, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + val;
            }
        }
        
        for(int i=0;i<m;i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        
        return answer;
    }
}