
import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String[] words = new String[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                words[i] = st.nextToken();
            }

            sb.append("#").append(test_case).append(" ");
            int interval = (N % 2 == 0) ? N / 2 : N / 2 + 1;
            for (int i = 0; i < N / 2; i++) {
                sb.append(words[i]).append(" ").append(words[i + interval]).append(" ");
            }

            if (N % 2 > 0) {
                sb.append(words[N / 2]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
