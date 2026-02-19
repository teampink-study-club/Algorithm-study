    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int max = Integer.MIN_VALUE;
            int count = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    count++;
                    max = arr[i];
                }
            }

            bw.write(count + "\n");
            bw.flush();
            bw.close();
            br.close();
        }
    }


