package BOJ.Greedy.Silver.P2847;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(bf.readLine());
            arr[i] = cur;
        }
        int prev = 20000;
        int sum = 0;
        for (int i = N-1; i >= 0; i--) {
            // 이전 것보다 같거나 크면
            if(arr[i]>=prev){
                // 이전 것보다 하나 크게 만들고
                sum += arr[i] - prev + 1;
                arr[i] = --prev;
            }else{
                prev = arr[i];
            }
        }
        System.out.println(sum);
    }
}
