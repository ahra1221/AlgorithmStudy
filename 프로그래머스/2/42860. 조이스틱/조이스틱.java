class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        for(int i=0;i<n;i++) {
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff,26-diff);
        }
        
        int move = n-1;
        for(int i=0;i<n;i++) {
            int nxt = i+1;
            while(nxt<n && name.charAt(nxt) == 'A') {
                nxt++;
            }
            
            // nxt -> 왼쪽으로 돌아서 오른쪽으로
            move = Math.min(move, i*2 + n - nxt);
            
            // nxt -> 오른쪽으로 돌아서 왼쪽으로
            move = Math.min(move, (n-nxt) * 2 + i);
        }
        
        return answer+move;
    }
}