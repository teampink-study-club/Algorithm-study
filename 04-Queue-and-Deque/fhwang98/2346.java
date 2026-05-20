import java.io.*;
import java.util.*;

public class Main {

    static class Balloon {
        int num;   // 풍선 번호
        int move;  // 이동 값
        Balloon(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Balloon> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int move = Integer.parseInt(st.nextToken());
            list.add(new Balloon(i, move));
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (!list.isEmpty()) {
            Balloon cur = list.remove(index);
            sb.append(cur.num).append(' ');

            if (list.isEmpty()) break;

            int size = list.size();
            int step = cur.move;

            if (step > 0) {
                // 제거 직후 index 위치에 "다음 풍선"이 당겨져 오므로 step-1만큼 이동
                index = (index + (step - 1)) % size;
            } else {
                // 음수 이동(왼쪽): 그대로 더하고 모듈러 음수 보정
                index = (index + step) % size;
                if (index < 0) index += size;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
