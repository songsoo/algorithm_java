package BOJ.BruteForce.DFS.G4.P5569;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result=0;
    static int[] moveX={1,0}, moveY={0,1};
    static int[][][] count;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\BOJ\\BruteForce\\DFS\\G4\\P5569\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(count[i][j], 0);
            }
        }
        count[0][0][0] = 0;
        count[0][0][1] = 0;
        count[N-1][M-1][0] = 1;
        count[N-1][M-1][1] = 1;
        dfs(0,0,false,-1);
        printArr();
        System.out.println((count[0][0][0]+count[0][0][1])%100000);
    }

    public static int dfs(int x, int y, boolean curve, int dir){
        System.out.println(x+" " +y+" " +curve+" "+dir);
        printArr();
        if(x+y==N+M-2){
            return 1;
        }
        int cnt=0;
        for (int i = 0; i < 2; i++) {
            // 2번 회전 방지하여 진입
            if(!(curve && dir!=i)){
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];
                int curCount = 0;

                if(check(nextX, nextY)){

                    //이미 가본 곳이면 정답 베끼고
                    if(count[nextX][nextY][0] != 0 && count[nextX][nextY][1] != 0 ){
                        if(nextX==N-1 && nextY==M-1){
                            curCount = 1;
                            count[x][y][i] += curCount;
                            cnt += curCount;
                            continue;
                        }
                        //이미 꺾었으면 같은 방향의 것만 가져오고
                        if(curve){
                            curCount += count[nextX][nextY][i];
                            count[x][y][i] += curCount;
                            cnt += curCount;

                        }
                        //아직 안꺾었으면 두 방향 모두 가져온다.
                        else{
                            //이번에 꺾으면 다음엔 안꺾는거만 가져온다.
                            if(dir==i) {
                                curCount += count[nextX][nextY][(i + 1) % 2];
                            }

                            curCount += count[nextX][nextY][i];
                            count[x][y][i] += curCount;
                            cnt += curCount;
                        }
                    }
                    //아직 못 가본 곳이면 직접 가본다.
                    else{
                        curCount = dfs(nextX,nextY,dir!=i && dir!=-1,i);
                        count[x][y][i] += curCount;
                        cnt += curCount;
                    }

                        if(dir==0 && nextX+2<N && nextY+2!=M){
                            curCount += count[nextX+2][nextY][(i + 1) % 2];
                            System.out.println("yup1 "+ count[nextX+2][nextY][(i + 1) % 2]);
                            count[x][y][i] += count[nextX+2][nextY][(i + 1) % 2];
                            cnt+=count[nextX+2][nextY][(i + 1) % 2];
                        }else if(dir==1 && nextY+2<M&& nextX+2!=N){
                            System.out.println("yup2 " +  count[nextX][nextY+2][(i + 1) % 2]);
                            curCount += count[nextX][nextY+2][(i + 1) % 2];
                            count[x][y][i] += count[nextX][nextY+2][(i + 1) % 2];
                            cnt+=count[nextX][nextY+2][(i + 1) % 2];
                        }else{
                            System.out.println("yup3 ");
                        }


                }

            }
        }
        return cnt;
    }
    public static void printArr(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(count[i][j][0]+count[i][j][1]+" ");
            }
            /*System.out.print(" ");
            for (int j = 0; j < M; j++) {
                System.out.print(count[i][j][1]+" ");
            }*/
            System.out.println();
        }
        System.out.println();
    }

    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }
    public static boolean canGo(int x,int y, boolean curved, int dir){
        if(curved && ((x==N-1 && dir==0)||(y==M-1 && dir==1))){
            return false;
        }return true;
    }
}
