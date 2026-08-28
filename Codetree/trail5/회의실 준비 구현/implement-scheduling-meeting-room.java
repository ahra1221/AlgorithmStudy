import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Time {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Time[] times = new Time[N];
        for(int i=0;i<N;i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(str.nextToken());
            int en = Integer.parseInt(str.nextToken());
            times[i] = new Time(st,en);
        }
        Arrays.sort(times, (a,b) -> Integer.compare(a.end, b.end));

        int cnt = 1;
        int ne = times[0].end;
        for(int i=1;i<N;i++) {
            if(times[i].start >= ne) {
                ne = times[i].end;
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}