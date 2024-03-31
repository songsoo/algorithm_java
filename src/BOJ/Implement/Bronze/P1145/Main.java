package BOJ.Implement.Bronze.P1145;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int[][] values = new int[5][100];

        for (int i = 0; i < 5; i++) {

            int cur = sc.nextInt();
            int idx = 2;

            while(cur>1){
                if(cur%idx==0){
                    values[i][idx]++;
                    cur/=idx;
                }else{
                    idx++;
                }
            }

        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = i+1; j < 5; j++) {
                for (int k = j+1; k < 5; k++) {
                    int cur = 1;
                    for (int l = 2; l < 100; l++) {
                        cur *= Math.pow(l, Math.max(Math.max(values[i][l], values[j][l]),values[k][l]));
                    }
                    min = Math.min(min, cur);
                }
            }
        }

        System.out.println(min);


    }
}
