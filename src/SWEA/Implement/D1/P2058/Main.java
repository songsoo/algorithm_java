package SWEA.Implement.D1.P2058;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum=0;
        while(N>=10){
            sum += N%10;
            N/=10;
        }
        sum += N;
        System.out.println(sum);

    }
}
