import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = sc.nextInt();
        }

        int maxSum = nums[0];
        int tmp = nums[0];
        for(int i=1;i<N;i++) {
            if(tmp < 0) {
                tmp = nums[i];
            } else {
                tmp += nums[i];
            }
            maxSum = Math.max(tmp, maxSum);
        }
        System.out.println(maxSum);
    }
}