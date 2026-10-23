class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while(n>0) {
            int remain = n % 3;
            if(remain == 0) {
                answer.append(4);
                n = n/3 -1;
            } else {
                answer.append(remain);
                n /= 3;
            }
        }
        return answer.reverse().toString();
    }
}