import java.io.*;
import java.util.*;

class Solution {
    
    StringTokenizer st;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> tmp = new HashSet<>(Arrays.asList(report));
        report = tmp.toArray(new String[0]);
        
        HashMap<String, Integer> reportCount = new HashMap<>();
        HashMap<String, HashSet<String>> reportList = new HashMap<>();
        int maxCount = 0;
        for(String rep: report) {
            st = new StringTokenizer(rep);
            String a = st.nextToken();
            String b = st.nextToken();
            reportCount.put(b, reportCount.getOrDefault(b, 0) + 1);
            reportList.computeIfAbsent(a, v -> new HashSet<>()).add(b);
            maxCount = Math.max(maxCount, reportCount.get(b));
        }
        
        int[] answer = new int[id_list.length];
        if(maxCount >= k) {
            HashSet<String> reported = new HashSet<>();
            for(Map.Entry<String, Integer> entry: reportCount.entrySet()) {
                if(entry.getValue() >= k) {
                    reported.add(entry.getKey());
                }
            }
            
            for(int i=0;i<id_list.length;i++) {
                reportList.getOrDefault(id_list[i], new HashSet<>()).retainAll(reported);
                answer[i] = reportList.getOrDefault(id_list[i], new HashSet<>()).size();
            }
        }
        
        return answer;
    }
}