package SWEA.Implement.D1.P2071;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            float sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += sc.nextInt();
            }
            sum /= 10;
            sum = Math.round(sum);
            System.out.printf("#"+(i+1)+" %.0f\n",sum);
        }
    }

}
