package BOJ.BruteForce.BackTracking.G5.P2023;

import java.util.Scanner;

public class Main {
    public static int N;
    public static int arrSize;
    public static int[] primes = {2,3,5,7};
    public static int[] adders = {1,3,7,9};
    public static int[] kim;
    public static boolean[] isPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arrSize = (int)Math.pow(10,N);
        kim = new int[N];
        /*isPrime = new boolean[arrSize];
        Arrays.fill(isPrime,true);
        int i =2;
        while(i<arrSize){
            if(isPrime[i]){
                check(i);
            }
            i++;
        }*/
        permutation(0,0);
        System.out.println(sb.toString());
    }

    public static void check(int i){
        int cur=i*2;
        while(cur<arrSize){
            isPrime[cur]=false;
            cur += i;
        }
    }


    public static boolean isPrime(int i){
        if(i==1){
            return false;
        }
        for (int j = 2; j <= (int)Math.sqrt(i); j++) {
            if(i%j==0)return false;
        }
        return true;
    }
    static StringBuilder sb = new StringBuilder();
    public static void permutation(int index,int num){
        if(index==N){
            if(isPrime(num)){
                sb.append(num+"\n");
            }
            return;
        }
        if(index==0){
            for (int i = 0; i < primes.length; i++) {
                permutation(index+1,primes[i]);
            }
        }else{
            for (int i = 0; i < adders.length; i++) {
                int cur = num*10;
                cur += adders[i];
                if(isPrime(cur)){
                    permutation(index+1,cur);
                }
            }
        }
    }


}
