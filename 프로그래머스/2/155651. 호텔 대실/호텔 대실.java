import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a,b) -> a[0].compareTo(b[0]));
        List<String> room = new ArrayList<>();
        for(String[] time: book_time) {
            String st = time[0], en = time[1];
            
            boolean hasRoom = false;
            for(int i=0;i<room.size();i++) {
                String endTime = room.get(i);
                if(st.compareTo(endTime) >= 0) {
                    room.remove(i);
                    room.add(calTime(en));
                    hasRoom = true;
                    break;
                }
            }
            
            if(!hasRoom) {
                room.add(calTime(en));
                answer++;
            }
        }
        return answer;
    }
    
    static String calTime(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]);
        int min = Integer.parseInt(tmp[1]) + 10;
        if(min >= 60) {
            hour += 1;
            min -= 60;
        }
        return String.format("%02d:%02d",hour,min);
    }
}