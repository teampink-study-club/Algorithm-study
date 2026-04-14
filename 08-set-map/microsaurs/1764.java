import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            set.add(br.readLine());
        }

        for(int i=0; i<m; i++) {
            String name = br.readLine();
            if(set.contains(name)) {
                answer.add(name);
            }
        }

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for(String name : answer) {
            sb.append(name).append('\n');
        }

        System.out.println(sb);
    }
}
