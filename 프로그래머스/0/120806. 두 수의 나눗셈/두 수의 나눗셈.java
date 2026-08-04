class Solution {
    public int solution(int num1, int num2) {
        double tmp = (double)num1 / (double)num2 * 1000;
        int answer = (int) tmp;
        return answer;
    }
}