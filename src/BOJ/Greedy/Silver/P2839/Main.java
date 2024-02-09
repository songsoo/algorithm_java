package BOJ.Greedy.Silver.P2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = -1;
        int i = n/5;
        while(i>=0){
            if((n - (i * 5))%3==0){
                result = i + (n-(5*i))/3;
                break;
            }
            i--;
        }
        System.out.println(result);

    }
}
