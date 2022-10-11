package SDS_day1.P1103N;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M,result=0;
    static int[][] board;
    static boolean found=false;
    static int[] moveX = {1,-1,0,0};
    static int[] moveY = {0,0,1,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS_day1/P1103/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][];
        visited = new boolean[N][];

        for (int i = 0; i < N; i++) {

            board[i] = new int[M];
            visited[i] = new boolean[M];
            st = new StringTokenizer(bf.readLine());
            String row = st.nextToken();

            for(int j = 0; j<M;j++){
                char readChar = row.charAt(j);
                if(readChar=='H'){
                    board[i][j] = -1;
                }else{
                    board[i][j] = readChar - '0';
                }
            }
        }
        dfs(0,0,0);
        System.out.println(result==Integer.MAX_VALUE?-1:result);


    }

    public static void dfs(int x, int y, int count){

        visited[x][y] = true;
        if(found){
            return;
        }
        for(int i=0;i<4;i++){

            int newX,newY;
            newX = x + board[x][y]*moveX[i];
            newY = y + board[x][y]*moveY[i];

            if(!(newX<0) && !(newX>=N) &&!(newY<0) && !(newY>=M)){
                if(!(board[newX][newY]==-1)) {
                    if (visited[newX][newY]) {
                        result =  Integer.MAX_VALUE;
                        found = true;
                        return;
                    } else {
                        dfs(newX,newY,count+1);
                    }
                }
            }else{
                result = Math.max(result, count+1);
            }
        }
        visited[x][y] = false;
    }



}
