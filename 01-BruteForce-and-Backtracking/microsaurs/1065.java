import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
    
        int cnt = Math.min(N, 99);
    
        for(int i = 100; i < 1000 && i <= N; i++) {
            int a = i % 10;
            int b = (i/10) % 10;
            int c = (i/100) % 10;

            if(b-a == c-b) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}