import java.util.*;

class Solution {
    public int[] solution(String s) {
        int level = 0;
        int remove = 0;
        while(!s.equals("1")) {
            int before = s.length();
            s = s.replace("0","");
            remove += before-s.length();
            s = Integer.toBinaryString(s.length());
            level++;
        }
        return new int[]{level, remove};
    }
}