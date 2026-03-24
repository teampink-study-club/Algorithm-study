import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int move = 0;

    static void moveDisk(Deque<Integer> from, Deque<Integer> to, int fromIdx, int toIdx) {
        to.addLast(from.removeLast());
        sb.append(fromIdx).append(" ").append(toIdx).append('\n');
        move++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        Deque<Integer> s3 = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            s1.addLast(Integer.parseInt(st.nextToken()));
        }

        while(target >= 1) {
            if(s1.contains(target)) {
                while(s1.peekLast() != target) {
                    moveDisk(s1, s2, 1, 2);
                }
                moveDisk(s1, s3, 1, 3);
            } else {
                while(s2.peekLast() != target) {
                    moveDisk(s2, s1, 2, 1);
                }
                moveDisk(s2, s3, 2, 3);
            }
            target--;
        }

        System.out.println(move);
        System.out.print(sb);
    }
}
