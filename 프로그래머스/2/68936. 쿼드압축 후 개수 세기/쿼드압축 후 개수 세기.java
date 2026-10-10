class Solution {
    
    int[] answer = new int[2];
    int[][] arr;
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        divide(0,0,arr.length);
        return answer;
    }
    
    void divide(int r, int c, int size) {
        boolean same = true;
        int val = arr[r][c];
        
        for(int i=r;i<r+size;i++) {
            for(int j=c;j<c+size;j++) {
                if(arr[i][j] != val) {
                    same = false;
                    break;
                }
            }
            if(!same) break;
        }
        
        if(same) {
            answer[val] ++;
            return;
        }
        
        // 숫자 다르면 4등분
        int half = size / 2;
        divide(r,c,half);
        divide(r,c+half,half);
        divide(r+half,c,half);
        divide(r+half,c+half,half);
    }
}