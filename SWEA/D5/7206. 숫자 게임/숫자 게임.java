
import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static StringBuilder sb = new StringBuilder();

    static Map<Integer, Integer> dp;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            dp = new HashMap<>();

            int answer = split(String.valueOf(N), 0, new ArrayList<>());

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int split(String s, int idx, List<Integer> current) {
        if (idx == s.length()) {
            if (current.size() < 2) {
                return 0;
            }

            int cal = 1;
            for (int num : current) {
                cal *= num;
            }
            if (cal < 10) {
                return 1;
            }
            if (dp.containsKey(cal)) {
                return dp.get(cal) + 1;
            }

            int nxt = split(String.valueOf(cal), 0, new ArrayList<>());
            dp.put(cal, nxt);
            return nxt + 1;
        }

        int max = 0;
        for (int end = idx + 1; end <= s.length(); end++) {
            int num = Integer.parseInt(s.substring(idx, end));
            current.add(num);
            max = Math.max(max, split(s, end, current));
            current.remove(current.size() - 1);
        }
        return max;
    }
}
