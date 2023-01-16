package SWEA.D2.P1961;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int T;
    static int arr[][];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SWEA/D2/P1961/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int size = Integer.parseInt(st.nextToken());

            arr = new int[size][];

            for (int j = 0; j < size; j++) {
                arr[j] = new int[size];
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < size; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#"+(i + 1));
            //각 줄 출력
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    System.out.print(arr[size-1-k][j]);
                }
                System.out.print(" ");
                for (int k = 0; k < size; k++) {
                    System.out.print(arr[size-1-j][size-1-k]);
                }
                System.out.print(" ");
                for (int k = 0; k < size; k++) {
                    System.out.print(arr[k][size-1-j]);
                }
                System.out.println();
            }



        }


    }
}
