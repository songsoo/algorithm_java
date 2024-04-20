package BOJ.BruteForce.SequentialSearch.Silver.P9881;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(bf.readLine());
            arr[i] = cur;
            if(min > cur){
                min = cur;
            }
            if(max < cur){
                max = cur;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = min; i <= max-17; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                // 범위 내에 있다면
                if(arr[j]>=i && arr[j]<=i+17){
                    continue;
                }else{
                    sum += Math.pow(Math.min(Math.abs(arr[j]-i), Math.abs(arr[j]-(i+17))),2);
                }
            }
            result = Math.min(result, sum);
        }

        System.out.println(result);



    }
}
