import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int K = Integer.parseInt(st.nextToken()) - 1;

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int index = 0;
        while (!list.isEmpty()) {
            index = (index + K) % list.size();
            sb.append(list.remove(index));
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append('>');

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}

