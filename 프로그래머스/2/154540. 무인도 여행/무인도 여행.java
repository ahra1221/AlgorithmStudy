import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        int n = maps.length;
        int m = maps[0].length();
        
        String[][] island = new String[n][m];
        for(int i=0;i<n;i++) {
            String[] tmp = maps[i].split("");   
            for(int j=0;j<m;j++) {
                island[i][j] = tmp[j];
            }
        }
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0;i<n;i++) { 
            for(int j=0;j<m;j++) {
                Queue<int[]> queue = new LinkedList<>();
                
                if (island[i][j].equals("X") || visited[i][j]) continue;
                
                int total = Integer.parseInt(island[i][j]);
                
                queue.offer(new int[]{i,j});
                visited[i][j] = true;
                
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0], y = cur[1];
                    for(int d=0;d<4;d++) {
                        int nx = x + dx[d], ny = y + dy[d];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(island[nx][ny].equals("X")) continue;
                        if(visited[nx][ny]) continue;

                        queue.offer(new int[]{nx,ny});
                        total += Integer.parseInt(island[nx][ny]);
                        visited[nx][ny] = true;
                    }
                }
                answer.add(total);
            }
        }
        if (answer.size() == 0) {
            answer.add(-1);
        }
        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}