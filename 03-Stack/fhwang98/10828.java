    import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                switch (st.nextToken()) {
                    case "push":
                        stack.push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                        break;
                    case "size":
                        sb.append(stack.size()).append("\n");
                        break;
                    case "empty":
                        sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                        break;
                    case "top":
                        sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                        break;
                    default:
                        break;
                }
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
        }
    }


