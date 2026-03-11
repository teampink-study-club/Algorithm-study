import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] nums;
    static int answer = 0;

    public static void dfs(int cur) {
        if(cur > N) return;

        answer = Math.max(answer, cur);

        for(int i=0; i<K; i++) {
            int next = cur * 10 + nums[i];
            dfs(next);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[K];

        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<K; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
    }
}
