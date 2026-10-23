class Solution{
    public int solution(int [][]board){
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=0;i<n;i++) {
            dp[i][0] = board[i][0];
            answer = Math.max(answer, dp[i][0]);
        }
        
        for(int j=0;j<m;j++) {
            dp[0][j] = board[0][j];
            answer = Math.max(answer, dp[0][j]);
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++) {
                if(board[i][j] == 1) {
                    int left = dp[i][j-1];
                    int up = dp[i-1][j];
                    int cross = dp[i-1][j-1];
                    dp[i][j] = Math.min(left, Math.min(up, cross))+1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer * answer;
    }
}