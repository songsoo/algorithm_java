package SWEA.D2.P1204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SWEA/D2/P1204/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int sumCross1, sumCross2;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st;
            bf.readLine();
            arr = new int [100][];
            int max=0;
            for (int j = 0; j < 100; j++) {
                arr[j] = new int[100];
            }
            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(bf.readLine());
                int sum = 0;
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    sum+=arr[j][k];
                }
                max = Math.max(max,sum);
            }
            sumCross1=0;
            sumCross2=0;
            for (int j = 0; j < 100; j++) {
                int sum = 0;
                for (int k = 0; k < 100; k++) {
                    sum += arr[k][j];
                    if (j == k) {
                        sumCross1 += arr[k][j];
                    }
                    if ((j + k) == 99) {
                        sumCross2 += arr[k][j];
                    }
                }
                max = Math.max(sum, max);
            }
            max = Math.max(max, Math.max(sumCross1,sumCross2));
            System.out.println("#"+(i+1)+" "+max);
        }

    }
}
