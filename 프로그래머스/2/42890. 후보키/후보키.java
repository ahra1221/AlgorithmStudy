import java.util.*;

class Solution {
    
    int K;
    int columCnt;
    int[] selected;
    List<Integer> keys = new ArrayList<>();
    String[][] relation;
    
    public int solution(String[][] relation) {
        this.relation = relation;
        columCnt = relation[0].length;
        for(K=1;K<=columCnt;K++) {
            selected = new int[K];
            comb();
        }
        return keys.size();
    }
    
    void comb() {
        for(int mask=1;mask<(1<<columCnt);mask++) {
            if (!checkMinimality(mask)) continue;
            if (!checkUnique(mask)) continue;
            keys.add(mask);
        }
    }
    
    boolean checkUnique(int select) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<relation.length;i++) {
            String tmp = "";
            for(int c=0;c<columCnt;c++) {
                if((select & (1<<c)) != 0) {
                    tmp += relation[i][c] + "#";
                }
            }
            set.add(tmp);
        }
        return set.size() == relation.length;
    }
    
    boolean checkMinimality(int select) {
        for(int key: keys) {
            if((select & key) == key) {
                return false;
            }
        }   
        return true;
    }
}