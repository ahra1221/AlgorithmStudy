import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a,b) -> a[0].compareTo(b[0]));
        PriorityQueue<String> rooms = new PriorityQueue<>();
        for(String[] time: book_time) {
            String st = time[0], en = time[1];
            if(!rooms.isEmpty() && st.compareTo(rooms.peek()) >= 0) {
                rooms.poll();
            }
            rooms.offer(calTime(en));
        }
        return rooms.size();
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