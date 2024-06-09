package BOJ.BruteForce.BackTracking.Silver.P1051;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result;
    static int[][] map;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = 1;
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String input = bf.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int curMaxLength = Math.min(R-i, C-j);
                for (int k = 1; k < curMaxLength; k++) {
                    if(map[i][j]==map[i][j+k] && map[i][j]==map[i+k][j] && map[i][j]==map[i+k][j+k]){
                        result = Math.max(result, k+1);
                    }
                }
            }
        }

        System.out.println((int)Math.pow(result,2));



    }

}
