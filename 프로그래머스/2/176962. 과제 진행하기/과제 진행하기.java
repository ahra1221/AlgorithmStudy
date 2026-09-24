import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Arrays.sort(plans, (a,b) -> {
            return a[1].compareTo(b[1]); 
        });
        
        List<String> complete = new ArrayList<>();
        Deque<String[]> wait = new ArrayDeque<>(); // [name, lefttime]
        
        for(int i=0;i<plans.length-1;i++) {
            String[] plan = plans[i];
            String[] nxtPlan = plans[i+1];
            // String name = plan[0], String start = plan[1];
            int playtime = Integer.parseInt(plan[2]);
            
            int between = calBetween(plan[1], nxtPlan[1]);
            if(between < playtime) { // 대기 처리
                wait.offerLast(new String[]{plan[0],String.valueOf(playtime - between)});
            } else { // 남은시간동안 대기목록 처리
                complete.add(plan[0]);
                int left = between - playtime;
                while(left > 0 && !wait.isEmpty()) {
                    String[] w = wait.pollLast();
                    int wt = Integer.parseInt(w[1]);
                    if(wt <= left) { // 완료된거임
                        complete.add(w[0]);
                    } else {
                        wait.offerLast(new String[]{w[0],String.valueOf(wt-left)});
                    }
                    left -= wt;
                }
            }
        }
        
        complete.add(plans[plans.length-1][0]);
        // 대기 목록 처리
        
        while(wait.size() > 0) {
            complete.add(wait.pollLast()[0]);
        }
        
        for(int i=0;i<complete.size();i++) {
            answer[i] = complete.get(i);
        }
        return answer;
    }
    
    int calBetween(String time1, String time2) {
        String[] t1 = time1.split(":");
        String[] t2 = time2.split(":");
        int between = (Integer.parseInt(t2[0]) - Integer.parseInt(t1[0])) * 60 + (Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]));
        return between;
    }
}