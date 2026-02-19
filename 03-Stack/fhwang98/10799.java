import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int open = 0;
        int result = 0;

        for (int i = 0; i < line.length(); i++) {
            char cur = line.charAt(i);
            if (cur == '(') {
                open++;
            } else {
                open--;
                if (i > 0 && line.charAt(i - 1) == '(') {
                    result += open;
                } else {
                    result += 1;
                }
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}

