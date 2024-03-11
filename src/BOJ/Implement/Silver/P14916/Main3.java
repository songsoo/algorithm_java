package BOJ.Implement.Silver.P14916;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        // 1 3 : -1
        // 5로 나눠서 나머지가 홀수면 5를 하나 줄이고
        if(n == 1 || n== 3){
            cnt = -1;
        }else{
            if((n%5)%2==0){
                cnt += n/5;
            }else{
                cnt += (n/5)-1;
                cnt = cnt==-1?0:cnt;
            }
            n -= cnt * 5;
            cnt += n/2;
        }
        System.out.println(cnt);

    }
}
