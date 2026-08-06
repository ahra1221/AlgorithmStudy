import java.util.*;
class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[] dx = {0,1,-1,0,0,-1,-1,1,1};
        int[] dy = {0,0,0,1,-1,-1,1,-1,1};
        Set<Pair> danger = new HashSet<>();
        for(int r=0;r<n;r++) {
            for(int c=0;c<n;c++) {
                if(board[r][c] == 1) {
                    for(int d=0;d<9;d++) {
                        int nr = r + dx[d];
                        int nc = c + dy[d];
                        if(0<=nr && nr<n && 0<=nc && nc<n) {
                            danger.add(new Pair(nr,nc));
                        }
                    }
                }
            }
        }
        int answer = Math.max(n * n - danger.size(), 0);
        return answer;
    }
}