package BOJ.Implement.Silver.P1094;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while(n>0){
            if(n%2==1){
                cnt++;
            }
            n/=2;
        }
        System.out.println(cnt);
    }
}
