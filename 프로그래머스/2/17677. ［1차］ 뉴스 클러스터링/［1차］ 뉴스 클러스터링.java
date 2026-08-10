import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Integer> map1 = splitStr(str1);
        Map<String,Integer> map2 = splitStr(str2);
        
        // 합집합
        Map<String,Integer> union = new HashMap<>();
        for(String key1: map1.keySet()) {
            union.put(key1, Math.max(map1.get(key1), map2.getOrDefault(key1,0)));
        }
        for(String key2: map2.keySet()) {
            union.put(key2, Math.max(map1.getOrDefault(key2,0), map2.get(key2)));
        }
        
        // 교집합
        Map<String,Integer> intersection = new HashMap<>();
        for(String key1: map1.keySet()) {
            int cnt = Math.min(map1.get(key1), map2.getOrDefault(key1,0));
            if (cnt > 0) {
                intersection.put(key1,cnt);
            }
        }
        for(String key2: map2.keySet()) {
            int cnt = Math.min(map1.getOrDefault(key2,0), map2.get(key2));
            if(cnt > 0) {
                intersection.put(key2,cnt);
            }
        }
        
        double unionCnt = union.values().stream().mapToInt(Integer::intValue).sum();
        double intersectionCnt = intersection.values().stream().mapToInt(Integer::intValue).sum();
        if(unionCnt == 0 && intersectionCnt == 0) {
            answer = 65536;
        } else {
            answer = (int)(intersectionCnt / unionCnt * 65536);
        }
        return answer;
    }
    
    public static Map<String,Integer> splitStr(String str) {
        Map<String,Integer> parts = new HashMap<>();
        for(int i=0;i<str.length()-1.;i++) {
            String substr = str.substring(i,i+2).toLowerCase();
            if(substr.matches("[a-zA-Z]{2}")) {
                parts.put(substr, parts.getOrDefault(substr,0) + 1);
            }
        }
        return parts;
    }
}