package Test.Later;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P21611 {
    static int N,M;
    static int[][] arr;
    static int[] moveX={0,1,0,-1},moveY={1,0,-1,0};
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        list = new ArrayList<>();

        int x = 0;
        int y = 0;
        int rot = 0;
        while(x!=(N+1)/2 && y!=(N+1)/2){
           if(arr[x][y]!=0){
               list.add(0,arr[x][y]);
           }

           /*if(){

           }*/
        }

    }
    public static boolean check(int x, int y){
        if(x>=0 && y>=0 && x<N && y<N){
            return true;
        }
        return false;
    }
}
