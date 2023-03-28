package BOJ.DP.S3.P1463;

import java.util.Scanner;

public class P1463 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        if(n>1){
            arr[2] = 1;
        }
        if(n>2){
            arr[3] = 1;
        }
        for (int i = 4; i < n+1; i++) {
            int a = arr[i-1] + 1;

            if((i%2)==0){
                a = Math.min(a,arr[i/2]+1);
            }

            if((i%3)==0){
                a = Math.min(a,arr[i/3]+1);
            }
            arr[i] = a;
        }
        System.out.println(arr[n]);
    }
}
