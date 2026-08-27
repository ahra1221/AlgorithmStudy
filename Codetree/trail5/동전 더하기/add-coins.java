import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coins = new int[N];
        for(int i=0;i<N;i++) {
            coins[i] = sc.nextInt();
        }
        
        int cnt = 0;
        for(int i=N-1;i>=0;i--) {
            cnt += K / coins[i];
            K %= coins[i];
        }
        System.out.println(cnt);
    }
}