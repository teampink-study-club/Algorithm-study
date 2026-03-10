import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static char[][] sign;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        sign = new char[N][N];
        arr = new int[N];

        int idx = 0;
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                sign[i][j] = input.charAt(idx++);
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    static boolean dfs(int depth) {
        if(depth == N) return true;

        if(sign[depth][depth] == '0') {
            arr[depth] = 0;
            if(check(depth)) {
                if(dfs(depth + 1)) return true;
            }
        } else if (sign[depth][depth] == '+') {
            for(int num=1; num<=10; num++) {
                arr[depth] = num;
                if(check(depth)) {
                    if(dfs(depth+1)) return true;
                }
            }
        } else {
            for(int num = -10; num<= -1; num++) {
                arr[depth] = num;
                if(check(depth)) {
                    if(dfs(depth+1)) return true;
                }
            }
        }
        return false;
    }
    
    static boolean check(int end) {
        int sum = 0;

        for(int i = end; i>=0; i--){
            sum += arr[i];

            if(sum > 0) {
                if(sign[i][end] != '+') return false;
            } else if(sum < 0) {
                if(sign[i][end] != '-') return false;
            } else {
                if(sign[i][end] != '0') return false;
            }
        }

        return true;
     }
}
