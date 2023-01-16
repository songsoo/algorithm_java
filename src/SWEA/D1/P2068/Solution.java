package SWEA.D1.P2068;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int N;
        ArrayList<Integer> list;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                list.add(sc.nextInt());
            }
            Collections.sort(list, Collections.reverseOrder());
            System.out.println("#"+(i+1)+" "+list.get(0));
        }
    }

}
