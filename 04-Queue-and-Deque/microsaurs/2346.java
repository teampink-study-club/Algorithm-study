import java.io.*;
import java.util.*;

public class Main {
    static class Balloon {
            int index;
            int move;

            Balloon(int index, int move) {
                this.index = index;
                this.move = move;
            }
        }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {
            int move = Integer.parseInt(st.nextToken());
            dq.add(new Balloon(i, move));
        }

        StringBuilder sb = new StringBuilder();

        while(!dq.isEmpty()) {
            Balloon current = dq.pollFirst();
            sb.append(current.index).append(" ");

            if(dq.isEmpty()) break;

            int move = current.move;

            if(move > 0) {
                for(int i=0; i<move-1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for(int i=0; i<Math.abs(move); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}
