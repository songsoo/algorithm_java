package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KyeonInA {
    static int N, M, K;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int count = 0;
        if(K%2==0){
            K-=2;
        }else{
            K-=1;
        }
        count = (int)(Math.log(K)/Math.log(2));
        int totalFight = (int)(Math.log(N)/Math.log(2));

        if(count+M>totalFight){
            System.out.println(totalFight);
        }else{
            System.out.println(count+M);
        }
    }
}
