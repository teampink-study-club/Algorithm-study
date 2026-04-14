import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, Integer> trees = new TreeMap<>();
        int total = 0;
        
        while(true) {
            String name = br.readLine();
            if(name == null) break;

            trees.put(name, trees.getOrDefault(name, 0) + 1);
            total++;
        }

        StringBuilder sb = new StringBuilder();
        for(String name : trees.keySet()) {
            double per = (double) trees.get(name) / total * 100;
            sb.append(name).append(' ').append(String.format("%.4f\n", per));
        }

        System.out.print(sb);
    }
}
