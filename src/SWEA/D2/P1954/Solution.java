package SWEA.D2.P1954;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int end = sc.nextInt();
        int T;
        int test_case = 1;

        while(test_case<=end) {
            T = sc.nextInt();
            int[][] snail;
            int[] dx = {0, -1, 0, 1};
            int[] dy = {1, 0, -1, 0};

            int count = 1;
            snail = new int[T][];

            for (int i = 0; i < T; i++) {
                snail[i] = new int[T];
                snail[i][0] = count++;
            }

            int tiktok = 0;
            int jump = T - 1;
            int move = 0;
            int x = T - 1;
            int y = 0;
            while (jump > 0) {
                for (int i = 0; i < jump; i++) {
                    x += dx[move];
                    y += dy[move];
                    snail[x][y] = count++;
                }
                move = move == 3 ? 0 : move + 1;
                tiktok++;
                jump = tiktok == 2 ? jump - 1 : jump;
                tiktok = tiktok == 2 ? 0 : tiktok;
            }
            System.out.println("#" + test_case);
            test_case++;
            for (int i = 0; i < T; i++) {
                for (int j = 0; j < T; j++) {
                    System.out.print(snail[j][i] + " ");
                }
                System.out.println();
            }

        }


    }
}