import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] students = new int[N][3];
        String[] name = new String[N];
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
            students[i][2] = Integer.parseInt(st.nextToken());
        }

        Integer[] idx = new Integer[N];
        for(int i=0; i<N; i++) idx[i] = i;

        Arrays.sort(idx, (a,b) -> {
            if (students[a][0] != students[b][0]) return students[b][0] - students[a][0];
            if (students[a][1] != students[b][1]) return students[a][1] - students[b][1];
            if (students[a][2] != students[b][2]) return students[b][2] - students[a][2];
            return name[a].compareTo(name[b]);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(name[idx[i]]).append("\n");
        }

        System.out.println(sb);
    } 
}