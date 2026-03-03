import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        
        for(int i=0; i<T; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            
            Deque<Integer> dq = new ArrayDeque<>();
            if(n>0) {
                String[] nums = arrStr.substring(1, arrStr.length()-1).split(",");
                for(String num : nums) {
                    dq.add(Integer.parseInt(num));
                }
            }

            boolean isReversed = false;
            boolean error = false;

            for(char cmd : command.toCharArray()) {
                if(cmd == 'R') {
                    isReversed = !isReversed;
                } else {
                    if(dq.isEmpty()) {
                        error = true;
                        break;
                    }

                    if(isReversed) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }

            if(error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if(!dq.isEmpty()) {
                    if(isReversed) {
                        while(dq.size()>1) {
                            sb.append(dq.pollLast()).append(",");
                        }
                        sb.append(dq.pollLast());
                    } else {
                        while(dq.size() > 1) {
                            sb.append(dq.pollFirst()).append(",");
                        }
                        sb.append(dq.pollFirst());
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}
