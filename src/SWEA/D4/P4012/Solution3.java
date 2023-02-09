package SWEA.D4.P4012;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3 {
    static int T;
    static int N;
    static int countingStar=0;
    static int[][] sinergy;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\SWEA\\D4\\P4012\\input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            sinergy = new int[N][N];
            p = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = i;
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    sinergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sub = Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;

            do {
                min = Math.min(min, sub);
            } while (nextCom(N - 1));

            bw.write("#" + t + " " +String.valueOf(min) + "\n");

        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int sub = Integer.MAX_VALUE;
    private static int min = Integer.MAX_VALUE;
    static int[] p;
    private static boolean nextCom(int size) {
        System.out.println(Arrays.toString(p));
        int first = size;
        // 처음으로 꺾이는 지점 : first - 1
        while (first > 0 && p[first - 1] > p[first]) first--;
        if (first == 0) return false;
        // 그것보다 큰수: last
        int last = size;
        while (p[first - 1] > p[last]) last--;
        // 1차 스왑
        swap(first - 1, last);
        // 오름차순 정렬?
        int downstart = size;
        while (first < downstart) {
            swap(first, downstart);
            downstart--;
            first++;
        }
        // 사실 다 정렬되서 여기서 반 나눠서 구하면됨.
        counting();
        return true;
    }
    private static void counting() {
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (i == j) continue;
                if (i < N / 2 && j < N / 2) { // teamA
                    sumA = sumA + sinergy[p[i]][p[j]] + sinergy[p[j]][p[i]];
                }
                else if (i >= N / 2 && j >= N / 2){
                    sumB = sumB + sinergy[p[i]][p[j]] + sinergy[p[j]][p[i]];
                }
            }
        }
        sub = Math.abs(sumA - sumB);
    }
    private static void swap(int a, int b) {
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
}

