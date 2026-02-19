import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sum -= stack.pop();
            } else {
                stack.push(n);
                sum += n;
            }
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();
    }
}

