package BOJ.BruteForce.SequentialSearch.Silver.P1254;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        int p = str.length-1;
        int q = p;
        int max = 0;
        // 뒤부터 시작해서 가장 긴 대칭
        while(p>=0){
            //p~q가 대칭인지 확인
            int a = p;
            int b = q;
            boolean flag = true;
            while(a<b){
                if(str[a]!=str[b]){
                    flag = false;
                    break;
                }
                a++;
                b--;
            }
            if(flag){
                max = q-p+1;
            }
            p--;
        }
        System.out.println(str.length*2-max);
    }
}
