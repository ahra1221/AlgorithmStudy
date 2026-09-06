class Solution {
    public long solution(int n, int[] times) {     
        long max = 0;
        for(int t: times) max = Math.max(max,t);
        long left = 1, right = max * n;
        
        while(left < right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int time: times) {
                cnt += mid / time;
            }
            
            if(cnt >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}