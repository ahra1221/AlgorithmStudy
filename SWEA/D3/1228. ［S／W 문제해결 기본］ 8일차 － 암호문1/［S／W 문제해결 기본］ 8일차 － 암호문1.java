import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String args[]) throws Exception {

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> password = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                password.add(Integer.valueOf(st.nextToken()));
            }

            int cmd = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("I")) {
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < y; i++) {
                        password.add(x++, Integer.valueOf(st.nextToken()));
                    }
                }
            }
            
            sb.append("#").append(test_case);
            for (int i = 0; i < 10; i++) {
                sb.append(" ").append(password.get(i));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
