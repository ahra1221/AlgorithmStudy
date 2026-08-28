import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int[] nums = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            pq.offer(sc.nextInt());
        }
        
        int ans = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a+b);
            ans += a+b;
        }

        System.out.println(ans);
    }
}