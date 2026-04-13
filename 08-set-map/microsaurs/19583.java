import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken().replace(":", "");
        String e = st.nextToken().replace(":", "");
        String q = st.nextToken().replace(":", "");

        Set<String> attend = new HashSet<>();
        Set<String> answer = new HashSet<>();

        while(true) {
            String chat = br.readLine();
            if(chat == null) break;

            st = new StringTokenizer(chat);
            String time = st.nextToken().replace(":", "");
            String name = st.nextToken();

            if(time.compareTo(s) <= 0) {
                attend.add(name);
            }

            if(time.compareTo(e) >= 0 && time.compareTo(q) <= 0) {
                if(attend.contains(name)) answer.add(name);
            }
        }

        System.out.println(answer.size());
    }
}
