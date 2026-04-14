import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> num = new HashMap<>();
        Map<String, Integer> name = new HashMap<>();

        for(int i=1; i<=n; i++) {
            String s = br.readLine();
            num.put(i, s);
            name.put(s, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            String s = br.readLine();

            if(Character.isDigit(s.charAt(0))) {
                int a = Integer.parseInt(s);
                sb.append(num.get(a)).append('\n');
            } else {
                sb.append(name.get(s)).append('\n');
            }
            
        }
        System.out.println(sb);        
    }
}
