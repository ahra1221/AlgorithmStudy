import java.util.*;

class Solution {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        int[] decrease = {1, 2, 3, 4, 5};

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            Deque<Integer> nums = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                nums.offer(sc.nextInt());
            }

            int d = 0;
            while (true) {
                int nxt = nums.poll() - decrease[d];
                nums.addLast(Math.max(nxt, 0));
                if (nxt <= 0) {
                    break;
                }
                d = (d + 1) % 5;
            }

            sb.append("#").append(test_case).append(" ");
            for (int n : nums) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}