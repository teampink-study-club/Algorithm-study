import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Deque<Character> bracket = new ArrayDeque<>();
        Deque<Integer> values = new ArrayDeque<>();
        int temp = 0;
        boolean valid = true;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                bracket.push(c);
                values.push(temp);
                temp = 0;
            } else if(c == '[') {
                bracket.push(c);
                values.push(temp);
                temp = 0;
            } else if (c == ')') {
                if(bracket.isEmpty() || bracket.peek() != '(') {valid = false; break;}
                bracket.pop();
                temp = (temp == 0) ? 2 : temp * 2;
                temp += values.pop();
            } else if (c == ']') {
                if (bracket.isEmpty() || bracket.peek() != '[') { valid = false; break; }
                bracket.pop();
                temp = (temp == 0) ? 3 : temp * 3;
                temp += values.pop();
            }
        }
        
        System.out.println(!bracket.isEmpty() || !valid ? 0 : temp);
    }
}

