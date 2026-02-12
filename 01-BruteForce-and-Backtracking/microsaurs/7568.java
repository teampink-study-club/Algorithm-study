import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] weight = new int[N];
        int[] height = new int[N];
        int[] rank = new int[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i == j) continue;
                if(weight[j] > weight[i] && height[j] > height[i]) {
                    rank[i]++;
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            sb.append(rank[i] + 1).append(" ");
        }

        System.out.println(sb);
    } 
}
