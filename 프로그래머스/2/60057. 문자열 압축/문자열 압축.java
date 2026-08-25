class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        for(int sp=1;sp<=len/2;sp++) { // 자르는 단위 개수
            String zipString = "";
            
            String prev = "";
            int cnt = 1;
            for(int idx=0;idx<=len-sp;idx+=sp) {
                String tmp = s.substring(idx, idx+sp);
                
                if(tmp.equals(prev)) { // 같은 문자열 등장
                    cnt++;
                } else { // 다른 문자열 등장
                    zipString += (cnt > 1 ? cnt + prev : prev);
                    if(cnt > 1) cnt = 1;
                    prev = tmp;
                }
            }
            
            //남은거처리
            zipString += (cnt > 1 ? cnt + prev : prev);
            zipString += s.substring(len/sp * sp,len);
            answer = Math.min(answer, zipString.length());
        }
        
        return answer;
    }
}