package BOJ.NumberTheory.SieveOfEratosthenes;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int N, sub;
    static boolean[] map;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new boolean[N+1];

        for (int i = 2; i < Math.ceil(Math.sqrt(N+1)); i++) {
            if(!map[i]){
                for (int j = i*2; j < N+1; j+=i) {
                    map[j] = true;
                }
            }
        }
        int total = 0;
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 2; i < N+1; i++) {
            if(!map[i]){
                deque.add(i);
                total += i;
                while(total>N){
                    total -= deque.removeFirst();
                }
                if(total==N){
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}
