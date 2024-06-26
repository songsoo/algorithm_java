package BOJ.Implement.Gold.P10836;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, M;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][M];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            int x = M-1;
            int y = 0;

            st = new StringTokenizer(bf.readLine());

            int zero = Integer.parseInt(st.nextToken());
            x -= zero;
            if(x<0){
                y -= x;
                x = 0;
            }

            int one = Integer.parseInt(st.nextToken());
            for (int k = 0; k < one; k++) {
                arr[x][y] += 1;
                if(x>0){
                    x--;
                }else{
                    y++;
                }
            }

            int two = Integer.parseInt(st.nextToken());
            for (int k = 0; k < two; k++) {
                arr[x][y] += 2;
                if(x>0){
                    x--;
                }else{
                    y++;
                }
            }

        }

        for (int i = 0; i < M; i++) {
            sb.append((arr[0][i]+1)).append(" ");
        }
        sb.append("\n");

        for (int i = 1; i < M; i++) {
            sb.append((arr[i][0]+1)).append(" ");
            for (int j = 1; j < M; j++) {
                sb.append((arr[0][j]+1)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}