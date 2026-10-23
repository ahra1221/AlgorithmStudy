import java.util.*;

class Solution {
    
    StringTokenizer st;
    
    public String[] solution(String[] record) {
        List<String> msg = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        
        for(String rec: record) {
            String[] tmp = rec.split(" ");
            String id = tmp[1];
            switch(tmp[0]) {
                case "Enter":
                    user.put(id, tmp[2]);
                    msg.add(id + "/님이 들어왔습니다.");
                    break;
                case "Leave":
                    msg.add(id + "/님이 나갔습니다.");
                    break;
                case "Change":
                    user.put(id, tmp[2]);
                    break;
            }
        }
        
        String[] answer = new String[msg.size()];
        for(int i=0;i<msg.size();i++) {
            String[] tmp = msg.get(i).split("/");
            answer[i] = user.get(tmp[0]) + tmp[1];
        }
        
        return answer;
    }
}