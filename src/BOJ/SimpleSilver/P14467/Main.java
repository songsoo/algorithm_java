package BOJ.SimpleSilver.P14467;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int arr[] = new int[101];
        Arrays.fill(arr, -1);
        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());

            if(arr[cow]==-1){
                arr[cow] = loc;
            }else if(arr[cow]!=loc){
                arr[cow] = loc;
                count++;
            }
        }
        System.out.println(count);
    }
}
