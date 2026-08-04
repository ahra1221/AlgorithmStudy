class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int denom = lcm(denom1,denom2);
        int numer = numer1 * (denom / denom1) + numer2 * (denom / denom2);
        int g = gcd(denom, numer);
        answer[0] = numer / g;
        answer[1] = denom / g;
        return answer;
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}