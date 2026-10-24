import java.util.*;

class Solution {
    
    HashMap<String, Integer> menu;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        menu = new HashMap<>();
        for(String order: orders) {
            char[] ch = order.toCharArray();
            for(int size: course) {
                dfs(ch,new StringBuilder(),size,0);
            }
        }
        
        for(int size: course) {
            int max = 0;
            for(String key: menu.keySet()) {
                if(key.length() == size) {
                    max = Math.max(max, menu.get(key));
                }
            }
            
            if(max < 2) continue;
            
            for(String key: menu.keySet()) {
                if(key.length() == size && menu.get(key) == max) {
                    answer.add(key);   
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    void dfs(char[] ch, StringBuilder selected, int size, int start) {
        if(selected.length() == size) {
            char[] tmp = selected.toString().toCharArray();
            Arrays.sort(tmp);
            
            String s = new String(tmp);
            menu.put(s, menu.getOrDefault(s, 0) + 1); 
            return;
        }
        for(int i=start;i<ch.length;i++) {
            selected.append(ch[i]);
            dfs(ch,selected, size, i+1);
            selected.deleteCharAt(selected.length()-1);
        }
    }
}