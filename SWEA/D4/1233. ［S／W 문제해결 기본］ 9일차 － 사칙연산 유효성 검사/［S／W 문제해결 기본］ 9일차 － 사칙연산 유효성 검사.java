import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cnt = st.countTokens();

                st.nextToken();
                String val = st.nextToken();
                boolean isOperator = val.equals("+")
                        || val.equals("-")
                        || val.equals("*")
                        || val.equals("/");
                if (cnt == 4) { // 자식 2개 있음
                    if (!isOperator) {
                        answer = 0;
                    }
                } else if (cnt == 2) {
                    if (isOperator) {
                        answer = 0;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}