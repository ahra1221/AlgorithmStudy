import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        List<int[]> groups = new ArrayList<>();
        for(int i=0;i<minerals.length && i/5<totalPicks;i+=5) {
            int diamond = 0, iron = 0, stone = 0;
            for(int j=i;j<i+5&&j<minerals.length;j++) {
                String mineral = minerals[j];
                switch (mineral) {
                    case "diamond" -> diamond++;
                    case "iron" -> iron++;
                    case "stone" -> stone++;
                }
            }
            groups.add(new int[]{diamond, iron, stone});
        }
        groups.sort((a,b) -> {
            if(a[0] == b[0]) {
                return b[1]-a[1];
            }
            return b[0]-a[0];
        });
        
        
        int[][] exhaust = {
            {1,1,1},
            {5,1,1},
            {25,5,1},
        };
        int groupIdx = 0;
        for(int i=0;i<3;i++) {
            int pick = picks[i];
            int[] exh = exhaust[i];
            while(pick > 0 && groupIdx < groups.size()) {
                int[] group = groups.get(groupIdx++);
                for(int j=0;j<3;j++) {
                    answer += group[j] * exh[j];
                }
                pick--;
            }
        }
        return answer;
    }
}