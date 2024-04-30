package BOJ.BruteForce.SequentialSearch.Bronze.P14697;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int N = sc.nextInt();
        boolean flag = false;

        loop:
        for(int i=0; i<=N/a; i++){
            if(N%a==0){
                flag = true;
                break;
            }
            if(N-(i*a)%b==0){
                flag= true;
                break;
            }
            for(int j=0; j<=N/b; j++){
                if(i*a + j*b > N){
                    break;
                }
                if((N - (i*a + j*b)) % c ==0){
                    flag = true;
                    break loop;
                }
            }
        }

        System.out.println(flag?1:0);


    }
}
