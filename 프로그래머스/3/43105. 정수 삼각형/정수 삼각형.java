import java.util.*;

class Solution {
    
    int[][] triangle;
    int[][] path;
    
    public int solution(int[][] triangle) {
        this.triangle = triangle;
        path = new int[triangle.length][triangle.length];
        for(int[] r: path) {
            Arrays.fill(r, -1);
        }
        return dp(0,0);
    }
    
    int dp(int row, int col){
        if(row == triangle.length-1) {
            return triangle[row][col];
        }
        if(path[row][col] != -1) {
            return path[row][col];
        }
        
        int now = triangle[row][col];
        int left = dp(row+1,col);
        int right = dp(row+1,col+1);
        int res = now + Math.max(left, right);
        path[row][col] = res;
        return res;
    } 
}