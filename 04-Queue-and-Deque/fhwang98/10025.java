import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int MAX = 1000000;
        int[] arr = new int[MAX + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken()); // 얼음 양
            int x = Integer.parseInt(st.nextToken()); // 좌표
            arr[x] = g;
        }

        int windowLen = 2 * K + 1;

        long sum = 0;
        long ans = 0;

        // 초기 윈도우: [0 .. min(MAX, 2K)]
        int right = Math.min(MAX, 2 * K);
        for (int i = 0; i <= right; i++) {
            sum += arr[i];
        }
        ans = sum;

        // 슬라이딩: left가 1..MAX까지 움직이며
        // 윈도우는 [left .. left + 2K]
        for (int left = 1; left <= MAX; left++) {
            int outIdx = left - 1;          // 빠지는 인덱스
            int inIdx = left + 2 * K;       // 들어오는 인덱스

            sum -= arr[outIdx];
            if (inIdx <= MAX) sum += arr[inIdx];

            if (sum > ans) ans = sum;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
