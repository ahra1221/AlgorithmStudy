import java.util.*;

class Solution {
    
    int K;
    int columCnt;
    int[] selected;
    List<int[]> keys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        columCnt = relation[0].length;
        for(K=1;K<=columCnt;K++) {
            selected = new int[K];
            comb(relation,0,0);
        }
        return keys.size();
    }
    
    void comb(String[][] relation, int start, int depth) {
        if(depth == K) {
            if(!checkMinimality(selected)) return;
            if(!checkUnique(relation, selected)) return;
            keys.add(selected.clone());
            return;
        }
        for(int i=start;i<columCnt;i++) {
            selected[depth] = i;
            comb(relation,i+1, depth+1);
        }
    }
    
    boolean checkUnique(String[][] relation, int[] select) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<relation.length;i++) {
            String tmp = "";
            for(int key: select) {
                tmp += relation[i][key] + "#";
            }
            set.add(tmp);
        }
        return set.size() == relation.length;
    }
    
    boolean checkMinimality(int[] select) {
        for(int[] key: keys) {
            boolean include = true;
            for(int k: key) {
                boolean found = false;
                for(int s: select) {
                    if(k==s) {
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    include = false;
                    break;
                }
            }
            if(include) {
                return false;
            }
        }   
        return true;
    }
}