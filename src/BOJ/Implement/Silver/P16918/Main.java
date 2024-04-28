package BOJ.Implement.Silver.P16918;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        // 폭탄은 3초가 지난 후에 폭발, 인접한 네 칸을 파괴하며 폭탄도 파괴해버린다.
        // 봄버맨은 모든 칸을 자유롭게 이동 가능
        // 1초간 아무 것도 하지 않고
        // 폭탄이 설치되지 않은 모든 칸에 폭탄 설치
        // 폭탄 파괴
        // 반복
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] moveX = {-1,0,1,0}, moveY = {0,-1,0,1};

        char[][] map = new char[R][C];
        char[][] map2 = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        if(N==1){
            // nothing...
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }else if(N%2==1){

            for (int i = 0; i < R; i++) {
                Arrays.fill(map2[i], 'O');
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j]=='O'){
                        map2[i][j] = '.';
                        for (int k = 0; k < 4; k++) {
                            int nextI = i + moveX[k];
                            int nextJ = j + moveY[k];
                            if(nextI>=0 && nextI<R && nextJ>=0 && nextJ<C){
                                map2[nextI][nextJ] = '.';
                            }
                        }
                    }
                }
            }

            if(N%4==1){
                // 한 번 갔다 오기
                for (int i = 0; i < R; i++) {
                    Arrays.fill(map[i], 'O');
                }
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if(map2[i][j]=='O'){
                            map[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int nextI = i + moveX[k];
                                int nextJ = j + moveY[k];
                                if(nextI>=0 && nextI<R && nextJ>=0 && nextJ<C){
                                    map[nextI][nextJ] = '.';
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(map[i][j]);
                    }
                    System.out.println();
                }
            }else if(N%4==3){
                // 한 번 터지기
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(map2[i][j]);
                    }
                    System.out.println();
                }
            }
        }else{
            // 전체 꽉차기
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print('O');
                }
                System.out.println();
            }
        }


    }
}
