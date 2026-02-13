import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int result = 99;

        if (X < 100) result = X;
        
        for (int i = 100; i <= X; i++) {
            int hundreds = i / 100;
            int tens = (i % 100) / 10;
            int ones = i % 10;

            if (hundreds - tens == tens - ones) result++;
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}

