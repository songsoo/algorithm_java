package BOJ.TwoPointer.P2018;

import java.util.Scanner;

public class P2018 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int p=1, q=1;
        int sum = 1;
        int count = 0;
        while(p<=N){
            // 합이 더 크면
            if(sum > N){
                sum -= p++;
            }
            // 같으면
            else if(sum == N){
                count++;
                sum -= p++;
            }
            // 더 작으면
            else{
                sum += ++q;
            }
        }
        System.out.println(count);
    }
}
