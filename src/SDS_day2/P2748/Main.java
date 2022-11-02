package SDS_day2.P2748;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] array = new long[n+2];

        array[0] = 0;
        array[1] = 1;
        array[2] = 1;

        for (int i = 3; i < n+1; i++) {
            array[i] = array[i-1] + array[i-2];
        }

        System.out.println(array[n]);

    }


}
