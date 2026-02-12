import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dwarf = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }
        Arrays.sort(dwarf);

        int l = 0, r = dwarf.length - 1, target = sum - 100;
        while (l < r) {
            if (dwarf[l] + dwarf[r] == target) {
                break;
            } else if (dwarf[l] + dwarf[r] > target) {
                r--;
            } else {
                l++;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == r || i == l) continue;
            bw.write(String.valueOf(dwarf[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

