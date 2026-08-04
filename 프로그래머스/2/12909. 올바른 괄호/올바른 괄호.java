import java.util.*;

class Solution {
    boolean solution(String s) {
        List<Character> stack = new ArrayList<>();
        for(Character st: s.toCharArray()) {
            if (st == '(') {
                stack.add(st);
            } else {
                if(!stack.isEmpty() && stack.get(stack.size()-1) == '(') {
                    stack.remove(stack.size()-1);
                } else {
                    stack.add(st);
                    break;
                }
            }
        }

        return stack.isEmpty();
    }
}