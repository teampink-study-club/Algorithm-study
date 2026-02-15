import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        Stack<Character> stack = new Stack<>();
        int score = 0, mul = 1;
        boolean isValid = true;

        for (int i = 0; i < line.length(); i++) {
            char cur = line.charAt(i);

            if (cur == '(') {
                stack.push(cur);
                mul *= 2;
            } else if (cur == '[') {
                stack.push(cur);
                mul *= 3;
            } else if (cur == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    isValid = false;
                    break;
                }
                if (line.charAt(i - 1) == '(') {
                    score += mul;
                }
                stack.pop();
                mul /= 2;
            } else if (cur == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    isValid = false;
                    break;
                }
                if (line.charAt(i - 1) == '[') {
                    score += mul;
                }
                stack.pop();
                mul /= 3;
            }
        }

        if (!isValid || !stack.isEmpty()) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(score));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

