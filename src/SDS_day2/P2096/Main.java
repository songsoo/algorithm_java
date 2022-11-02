package SDS_day2.P2096;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] array, minCount,maxCount;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SDS_day2/P2096/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        array = new int[N][];
        minCount = new int[N][];
        maxCount = new int[N][];
        for (int i = 0; i < N; i++) {
            array[i] = new int[3];
            minCount[i] = new int[3];
            maxCount[i] = new int[3];
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
            if(i==0){
                minCount[i][0] = array[i][0];
                minCount[i][1] = array[i][1];
                minCount[i][2] = array[i][2];

                maxCount[i][0] = array[i][0];
                maxCount[i][1] = array[i][1];
                maxCount[i][2] = array[i][2];
            }else{
                minCount[i][0] = Math.min(array[i][0]+minCount[i-1][0],array[i][0]+minCount[i-1][1]);
                minCount[i][1] = Math.min(array[i][1]+minCount[i-1][0],array[i][1]+minCount[i-1][1]);
                minCount[i][1] = Math.min(minCount[i][1],array[i][1]+minCount[i-1][2]);
                minCount[i][2] = Math.min(array[i][2]+minCount[i-1][2],array[i][2]+minCount[i-1][1]);

                maxCount[i][0] = Math.max(array[i][0]+maxCount[i-1][0],array[i][0]+maxCount[i-1][1]);
                maxCount[i][1] = Math.max(array[i][1]+maxCount[i-1][0],array[i][1]+maxCount[i-1][1]);
                maxCount[i][1] = Math.max(maxCount[i][1],array[i][1]+maxCount[i-1][2]);
                maxCount[i][2] = Math.max(array[i][2]+maxCount[i-1][2],array[i][2]+maxCount[i-1][1]);
            }
        }
        System.out.print(Math.max(maxCount[N-1][0],Math.max(maxCount[N-1][1],maxCount[N-1][2]))+" ");
        System.out.println(Math.min(minCount[N-1][0],Math.min(minCount[N-1][1],minCount[N-1][2])));




    }
}
