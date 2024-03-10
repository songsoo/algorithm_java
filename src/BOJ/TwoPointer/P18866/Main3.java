package BOJ.TwoPointer.P18866;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[][] arr = new int[N][2];
        int[][] young = new int[N][2];
        int[][] old = new int[N][2];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int curHappy = Integer.parseInt(st.nextToken());
            int curTired = Integer.parseInt(st.nextToken());

            arr[i][0] = curHappy;
            arr[i][1] = curTired;

        }

        int minHappy = Integer.MAX_VALUE;
        int maxTired = 0;
        for (int i = 0; i < N; i++) {
            young[i][0] = minHappy = Math.min(minHappy, arr[i][0]==0?minHappy:arr[i][0]);
            young[i][1] = maxTired = Math.max(maxTired, arr[i][1]);
        }
        int maxHappy = 0;
        int minTired = Integer.MAX_VALUE;
        for (int i = N-1; i >= 0; i--) {
            old[i][0] = maxHappy = Math.max(maxHappy, arr[i][0]);
            old[i][1] = minTired = Math.min(minTired, arr[i][1]==0?minTired:arr[i][1]);
        }

        int result = 0;
        for (int i = 0; i < N-1; i++) {
            if(young[i][0] > old[i+1][0] && young[i][1] < old[i+1][1]){
                result = i+1;
            }
        }
        System.out.println(result==0?-1:result);

    }
}