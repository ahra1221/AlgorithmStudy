import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        
        HashMap<String, String> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(referral[i].equals("-")) {
                map.put(enroll[i], "minho");
            } else {
                map.put(enroll[i], referral[i]);
            }
        }
        
        HashMap<String, Integer> profit = new HashMap<>();
        for(String en: enroll) profit.put(en, 0);
        
        for(int i=0;i<amount.length;i++) {
            String sell = seller[i];
            int money = amount[i] * 100;
            while(money > 0) {
                if(!map.containsKey(sell)) break;
                int get = 0;
                if(money < 10) {
                    get = money;
                } else {
                    get = money - money / 10;
                }
                profit.put(sell, profit.get(sell) + get);
                sell = map.get(sell);
                money -= get;
            }
        }
        
        for(int i=0;i<n;i++) {
            answer[i] = profit.get(enroll[i]);
        }
        
        return answer;
    }
}