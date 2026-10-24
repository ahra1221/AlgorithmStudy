import java.util.*;

class Solution {
    
    String[] data;
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] line = new char[8];
    boolean[] visited = new boolean[8];
    int answer = 0;
    
    public int solution(int n, String[] data) {
        this.data = data;
        dfs(0);
        return answer;
    }
    
    void dfs(int depth) {
        if(depth == 8) {
            if(check()) answer++;
            return;
        }
        
        for(int i=0;i<8;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            line[depth] = friends[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }
    
    boolean check() {
        for(String d: data) {
            char a = d.charAt(0);
            char b = d.charAt(2);
            char op = d.charAt(3);
            int num = d.charAt(4) - '0';
            
            int posA = -1;
            int posB = -1;
            for(int i=0;i<8;i++) {
                if(line[i] == a) posA = i;
                if(line[i] == b) posB = i;
            }
            int dist = Math.abs(posA-posB)-1;
            
            if(op == '=' && dist != num) return false; 
            if(op == '>' && dist <= num) return false; 
            if(op == '<' && dist >= num) return false; 
        }
        return true;
    }
}