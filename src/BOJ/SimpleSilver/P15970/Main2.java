package BOJ.SimpleSilver.P15970;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    static int N;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList();
        }
        long lengthSum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st  = new StringTokenizer(bf.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            arr[color].add(pos);
        }
        for (int i = 0; i < N+1; i++) {
            Collections.sort(arr[i]);
        }
        for (int i = 1; i < N+1; i++) {
            int size = arr[i].size();
            if(size>0){
                int prev = arr[i].get(0);
                int cur = arr[i].get(1);
                lengthSum += cur - prev;
                for (int j = 1; j < size-1; j++) {
                    int next = arr[i].get(j+1);
                    lengthSum += Math.min(cur-prev, next-cur);
                    prev = cur;
                    cur = next;
                }
                lengthSum += cur - prev;
            }
        }
        System.out.println(lengthSum);

    }
}
