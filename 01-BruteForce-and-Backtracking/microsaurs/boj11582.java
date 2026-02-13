import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int blockSize = N/k;

        for (int i=0; i<N; i+= blockSize) {
            Arrays.sort(arr, i, i+blockSize);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            if (i>0) sb.append(" ");
            sb.append(arr[i]);
        }
        System.out.println(sb);
        
    } 
}