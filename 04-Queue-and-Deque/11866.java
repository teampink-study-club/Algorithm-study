import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=1; i<=N; i++) {
            dq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!dq.isEmpty()) {
            for(int i=0; i<K-1; i++) {
                dq.add(dq.poll());
            }

            sb.append(dq.poll());

            if(!dq.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
