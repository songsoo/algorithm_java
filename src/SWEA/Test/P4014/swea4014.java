package SWEA.Test.P4014;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4014 {

    static int[][] arr;
    static int N, X, count;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            count = 0;
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }

            }
            checkRow();
            checkCol();
            System.out.println("#"+test_case+" "+count);

        }
    }

    public static void checkRow(){

        loop:
        for (int i = 0; i < N; i++) {
            int cur = arr[i][0];
            visited = new boolean[N];

            for (int j = 1; j < N; j++) {
                int diff = cur-arr[i][j];
                cur = arr[i][j];
                if(diff==0){

                }else if(diff==1){
                    for (int k = 0; k < X; k++) {
                        if(check(i,j+k) && !visited[j+k] && arr[i][j+k]==cur){
                            visited[j+k]=true;
                        }else{
                            continue loop;
                        }
                    }
                }else if(diff>1){
                    continue loop;
                }
            }

            cur = arr[i][N-1];
            for (int j = N-2; j >= 0; j--) {
                int diff = cur-arr[i][j];
                cur = arr[i][j];
                if(diff==0){

                }else if(diff==1){
                    for (int k = 0; k < X; k++) {

                        if(check(i,j-k) && !visited[j-k] && arr[i][j-k]==cur){
                            visited[j-k]=true;
                        }else{
                            continue loop;
                        }
                    }
                }else if(diff>1){
                    continue loop;
                }
            }
            count++;
        }
    }
    public static void checkCol(){
        loop:
        for (int i = 0; i < N; i++) {
            int cur = arr[0][i];
            visited = new boolean[N];

            for (int j = 1; j < N; j++) {
                int diff = cur-arr[j][i];
                cur = arr[j][i];
                if(diff==0){

                }else if(diff==1){
                    for (int k = 0; k < X; k++) {
                        if(check(j+k,i) && !visited[j+k] && arr[j+k][i]==cur){
                            visited[j+k]=true;
                        }else{
                            continue loop;
                        }
                    }
                }else if(diff>1){
                    continue loop;
                }
            }

            cur = arr[N-1][i];
            for (int j = N-2; j >= 0; j--) {
                int diff = cur-arr[j][i];
                cur = arr[j][i];
                if(diff==0){

                }else if(diff==1){
                    for (int k = 0; k < X; k++) {
                        if(check(j-k,i) && !visited[j-k] && arr[j-k][i]==cur){
                            visited[j-k]=true;
                        }else{
                            continue loop;
                        }
                    }
                }else if(diff>1){
                    continue loop;
                }
            }
            count++;
        }
    }
    public static boolean check(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }
        return false;
    }
}
