import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] heights = new int[9];

        int total = 0;

        for(int i=0; i<9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            total += heights[i];
        }
        Arrays.sort(heights);

        int substract = total - 100;
        boolean found = false;

        for(int i=0; i<9; i++) {
            if(found) break;
            for(int j= i+1; j<9; j++) {
                if(heights[i] + heights[j] == substract) {
                    for(int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue; 
                        sb.append(heights[k]).append("\n");
                    }
                    found = true;                   
                    break;
                }
            }
        }
        System.out.println(sb);
    } 
}