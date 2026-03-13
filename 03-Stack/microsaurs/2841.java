import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Deque<Integer>[] dq = new ArrayDeque[7];
        for(int i=1; i<=6; i++) {
            dq[i] = new ArrayDeque<>();
        }

        int count = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while(!dq[line].isEmpty() && dq[line].peekLast() > fret) {
                dq[line].pollLast();
                count++;
            }
            
            if(!dq[line].isEmpty() && dq[line].peekLast() == fret) {
                continue;
            }

            dq[line].addLast(fret);
            count++;
        }
        System.out.println(count);
    }
}
