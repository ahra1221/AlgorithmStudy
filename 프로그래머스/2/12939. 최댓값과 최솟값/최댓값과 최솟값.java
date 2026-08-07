import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        List<Integer> nums = new ArrayList<>();
        for(String st: arr) {
            nums.add(Integer.parseInt(st));
        }
        String answer = Collections.min(nums) + " " + Collections.max(nums);
        return answer;
    }
}