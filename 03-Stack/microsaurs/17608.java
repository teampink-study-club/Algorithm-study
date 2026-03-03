import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<N; i++) {
            dq.add(Integer.parseInt(br.readLine()));
        }

        int last = dq.pollLast();
        int cnt = 1;

        for(int i=0; i<N-1; i++) {
            int cur = dq.pollLast();
            if(cur > last) {
                cnt++;
                last = cur;
            }
        }
        System.out.println(cnt);
    } 
}

