    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 치킨집의 개수
            int N = Integer.parseInt(br.readLine());
            int[] numbers = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            // 정렬을 진행하는 사람의 수
            int K = Integer.parseInt(br.readLine());

            // N / K 개씩 정렬
            int block = N / K;
            for (int i = 0; i < N - block + 1; i += block) {
                Arrays.sort(numbers, i, i + block);
            }

            for (int i = 0; i < N; i++) {
                bw.write(numbers[i] + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        }
    }


