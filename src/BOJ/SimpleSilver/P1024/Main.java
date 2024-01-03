package BOJ.SimpleSilver.P1024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(true){
            if(check(N,M)!=0){
                break;
            }else{
                M++;
            }
        }

    }
    public static int check(int N, int M){

        if(M>100){
            System.out.println(-1);
            return -1;
        }
        // 18 4
        //짝수일 때
        if(M%2==0){
            //짝수일 때 정확하게 나눠지면 피해야 한다.
            if(N%(M/2)==0 && N%M!=0){
                if((N/M)-(M/2)+1>=0){
                    for (int i = (N/M)-(M/2)+1; i <= (N/M)+(M/2); i++) {
                        System.out.println(i);
                    }
                    return 1;
                }else{
                    System.out.println(-1);
                    return -1;
                }
            }else{
                return 0;
            }
        }
        //홀수일 때
        else{
            if(N%M==0){
                if((N/M)-(M/2)>=0){
                    for (int i = (N/M)-(M/2); i <= (N/M)+(M/2); i++) {
                        System.out.println(i);
                    }
                    return 1;
                }else{
                    System.out.println(-1);
                    return -1;
                }
            }else{
                return 0;
            }
        }
    }
}
