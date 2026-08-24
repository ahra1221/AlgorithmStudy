import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for(int i=1;i*i<=yellow;i++) {
            if(yellow % i == 0) {
                int w = i, h = yellow / i;
                if(2*w + 2*h + 4 == brown) {
                    answer = new int[]{Math.max(w+2,h+2), Math.min(w+2,h+2)};
                }
            }
        }
        return answer;
    }
}