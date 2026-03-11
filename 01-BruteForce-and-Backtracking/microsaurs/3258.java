import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] obstacle = new boolean[n+1];

        if(m > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                obstacle[x] = true;
            }
        }

        for(int k=1; k<n; k++) {
            boolean[] visited = new boolean[n+1];
            int cur = 1;
            visited[cur] = true;

            while(true) {
                int next = ((cur - 1 + k) % n) + 1;

                if(obstacle[next]) break;
                if(next == z) {
                    System.out.println(k);
                    return;
                }
                if(visited[next]) break;
                visited[next] = true;
                cur = next;
            }
        }
    }
}
