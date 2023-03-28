package BOJ.DP.S3.P11726;

import java.util.Scanner;

public class Main {

    static long[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new long[n+1];
        arr[1] = 1;
        if(n>1){
            arr[2] = 2;
        }
        for (int i = 3; i < n+1; i++) {
            arr[i] = arr[i-1]%10007 + arr[i-2]%10007;
        }

        System.out.println(arr[n]%10007);
    }
}
