package SDS.P1837;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max = 1000000;
    static char[] P;
    static int K;
    static int[] prime;
    static boolean[] isNotPrime;
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        for(int i=2; i<max+1;i++){
            if(isNotPrime[i]==false){
                primes.add(i);
            }
            for(int j= i*2 ; j<max+1 ; j+=i){
                isNotPrime[j] = true;
            }
        }

        for(int prime:primes){
            if(prime >=K){
                break;
            }
            if(checkIsBad(prime)){
                System.out.println("BAD");
                return;
            }
        }
        System.out.println("GOOD");





    }

    static boolean checkIsBad(int x){
        int ret = 0;
        for (int i=0;i<P.length;i++){
            ret = (ret*10 + (P[i]-'0')) % x;
        }

        if(ret==0){
            return true;
        }else{
            return false;
        }
    }



}
