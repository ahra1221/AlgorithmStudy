import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[N];
        for(int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String ab = String.valueOf(a) + String.valueOf(b);
                String ba = String.valueOf(b) + String.valueOf(a);
                return ba.compareTo(ab);
            }
        });

        for(Integer num: nums) {
            sb.append(String.valueOf(num));
        }
        System.out.println(sb);
    }
}