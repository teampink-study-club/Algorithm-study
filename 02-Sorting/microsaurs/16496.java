import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();

        for(String s : arr) {
            sb.append(s);
        }
        
        System.out.println(sb.charAt(0) == '0' ? 0 : sb );
    }
}
