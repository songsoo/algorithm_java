package BOJ.CumulativeSum.Gold.P20002;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int map[][];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        map = new int[N+1][N+1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < N+1; j++) {
                int cur = Integer.parseInt(st.nextToken());
                map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + cur;
                int index = 1;
                while(check(i,j,index)){
                    int sum = map[i][j] - map[i-index][j] - map[i][j-index] + map[i-index][j-index];
                    max = Math.max(max, sum);
                    index++;
                }
            }
        }
        System.out.println(max);
    }

    public static boolean check(int i, int j, int index){
        return (i-index)>=0 && (j-index)>=0;
    }

}
