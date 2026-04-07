import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=1; i<=n; i++) {
            dq.offer(i);
        }

        while(!dq.isEmpty()) {
            if(dq.size() > 1) {
                dq.poll();
                dq.offer(dq.poll());
            } else {
                System.out.println(dq.poll());
            }
        }
        
    }
}
