import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 라이언(1) 위치만 저장 (최대 N개)
        int[] lions = new int[N];
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == 1) lions[count++] = i;
        }

        if (count < K) {
            bw.write("-1");
        } else {
            int answer = Integer.MAX_VALUE;
            for (int start = 0; start + K - 1 < count; start++) {
                int end = start + K - 1;
                int len = lions[end] - lions[start] + 1;
                if (len < answer) answer = len;
            }
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
