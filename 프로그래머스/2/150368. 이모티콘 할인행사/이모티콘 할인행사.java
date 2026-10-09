import java.util.*;

class Solution {
    
    int[] emoticons;
    int[][] users;
    Set<Integer> percent;
    int E;
        
    int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        E = emoticons.length;
        this.emoticons = emoticons;
        this.users = users;
        
        percent = new HashSet<>();
        for(int i=10;i<=40;i+=10) {
            percent.add(i);
        }
        dfs(new int[E], 0);
        return answer;
    }
    
    void dfs(int[] sale, int depth) {
        if(depth == E) {
            int[] res = check(sale); // 플러스 가입자, 판매액
            if(res[0] > answer[0] ||
              res[0] == answer[0] && res[1] > answer[1]) {
                answer = res;
            }
            return;
        }
        
        for(int p: percent) {
            sale[depth] = p;
            dfs(sale, depth+1);
        }
    }
    
    int[] check(int[] sale) {
        int[] emoticonPrice = new int[E];
        for(int i=0;i<E;i++) {
            emoticonPrice[i] = emoticons[i] * (100 - sale[i]) / 100;
        }
        
        int plusUser = 0;
        int total = 0;
        for(int i=0;i<users.length;i++) {
            int buy = 0;
            for(int j=0;j<E;j++) {
                if(sale[j] >= users[i][0]) {
                    buy += emoticonPrice[j];
                }
            }
            
            if(buy >= users[i][1]) {
                plusUser++;
            } else {
                total += buy;
            }
        }
        return new int[]{plusUser,total};
    }
}