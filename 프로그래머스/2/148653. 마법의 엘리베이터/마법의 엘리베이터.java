class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int cur = storey % 10;
            if(cur < 5) {
                answer += cur;
                storey /= 10;
            } else if(cur > 5) {
                answer += 10 - cur;
                storey = storey / 10 + 1;
            } else {
                int nxt = (storey / 10) % 10;
                answer += 5;
                if(nxt >= 5) {
                    storey = storey / 10 + 1;
                } else {
                    storey /= 10;
                }
            }
        }
        return answer;
    }
}