import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Deque<Long> dq = new ArrayDeque<>();
        long sum = 0;

        for(int i=0; i<K; i++) {
            long n = Long.parseLong(br.readLine());
            if(n != 0) {
                dq.push(n);
                sum += n;
            } else {
                sum -= dq.pop();
            }
        }
        System.out.println(sum);
    }
}
