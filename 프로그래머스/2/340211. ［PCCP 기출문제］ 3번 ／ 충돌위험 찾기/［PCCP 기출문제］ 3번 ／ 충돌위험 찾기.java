import java.util.*;

class Solution {
    
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
        
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Point)) return false;
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    int answer = 0;
    
    public int solution(int[][] points, int[][] routes) {
        int x = routes.length;
        int maxLen = 0;
        Map<Integer, List<Point>> path = new HashMap<>();
        for(int i=0;i<routes.length;i++) {
            List<Point> tmp = new ArrayList<>();
            for(int j=0;j<routes[i].length-1;j++) {
                int st = routes[i][j], en = routes[i][j+1];
                Point stp = new Point(points[st-1][0],points[st-1][1]);
                Point enp = new Point(points[en-1][0],points[en-1][1]);
                tmp.addAll(findRoute(stp, enp));
            }
            int last = routes[i][routes[i].length-1];
            tmp.add(new Point(points[last-1][0], points[last-1][1]));
            
            maxLen = Math.max(maxLen, tmp.size());
            path.put(i+1, tmp);
        }
        
        for(int i=0;i<maxLen;i++) {
            Map<Point, Integer> count = new HashMap<>();
            for(Map.Entry<Integer, List<Point>> entry: path.entrySet()) {
                if(entry.getValue().size() <= i) continue;
                Point p = entry.getValue().get(i);
                count.put(p, count.getOrDefault(p,0) + 1);
            }
            for(int cnt: count.values()) {
                if(cnt >= 2) answer++;
            }
        }
        
        return answer;
    }
    
    List<Point> findRoute(Point start, Point end) {
        List<Point> res = new ArrayList<>();
        if(start.x <= end.x) {
            for(int i=start.x;i<end.x;i++) {
                res.add(new Point(i, start.y));
            }
        } else {
            for(int i=start.x;i>end.x;i--) {
                res.add(new Point(i, start.y));
            }
        }
        
        if(start.y <= end.y) {
            for(int j=start.y;j<end.y;j++) {
                res.add(new Point(end.x,j));
            }
        } else {
            for(int j=start.y;j>end.y;j--) {
                res.add(new Point(end.x,j));
            }
        }
        
        return res;
    }
}