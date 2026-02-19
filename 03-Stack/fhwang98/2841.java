import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            stacks[i] = new Stack<>();
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!stacks[line].isEmpty() && stacks[line].peek() > fret) {
                stacks[line].pop();
                count++;
            }

            if (stacks[line].isEmpty() || stacks[line].peek() < fret) {
                stacks[line].push(fret);
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}

