import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        for(long number: numbers) {
            String binary = Long.toBinaryString(number);
            int size = 1;
            while(size < binary.length()) {
                size = size * 2 + 1;
            }
            binary = "0".repeat(size - binary.length()) + binary;
            answer[idx++] = isBinaryTree(binary) ? 1 : 0;
        }
        return answer;
    }
    
    boolean isBinaryTree(String binary) {
        if(binary.length() == 1) {
            return true;
        }
        
        int mid = binary.length() / 2;
        String left = binary.substring(0, mid);
        String right = binary.substring(mid+1);
        
        if(binary.charAt(mid) == '0') {
            if(left.contains("1") || right.contains("1")) {
                return false;
            }
        }
        
        return isBinaryTree(left) && isBinaryTree(right);
    }
}