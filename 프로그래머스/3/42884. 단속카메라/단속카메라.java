import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a,b) -> a[1] - b[1]);
        int camera = routes[0][1];
        for(int i=1;i<routes.length;i++) {
            if(routes[i][0] > camera || routes[i][1] < camera) {
                answer ++;
                camera = routes[i][1];
            }
        }
        return answer;
    }
}