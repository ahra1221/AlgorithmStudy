import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int wanho = scores[0][0] + scores[0][1];
        int wanhoA = scores[0][0], wanhoB = scores[0][1];
        
        Arrays.sort(scores, (a,b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } 
            return Integer.compare(b[0], a[0]);
        });
        
        int maxScore = 0;
        for(int[] score: scores) {
            if(score[1] < maxScore) {
                if(score[0] == wanhoA && score[1] == wanhoB) {
                    return -1;
                }
                continue;
            }
            maxScore = Math.max(maxScore, score[1]);
            if(score[0] + score[1] > wanho) {
                answer++;
            }
        }
        
        return answer;
    }
}