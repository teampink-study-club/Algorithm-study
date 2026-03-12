import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] temp;
    static long count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N-1);

        System.out.println(count);
    }
    
    static void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid+1, right);
        merge(left, mid, right);
    }   

    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid+1;
        int k = left;

        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for(int x=left; x<=right; x++) {
            arr[x] = temp[x];
        }
    }
}

