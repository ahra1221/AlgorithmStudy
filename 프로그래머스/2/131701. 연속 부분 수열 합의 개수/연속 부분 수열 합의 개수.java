import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        HashSet<Integer> sums = new HashSet<>();
        
        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=0;j<n;j++) {
                sum += elements[(i+j) % n];
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}