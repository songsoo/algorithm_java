package BOJ.DP.G3.P2342;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] foot;
    static int[][][] visited;
    static int size, min;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        size = st.countTokens()-1;
        min = Integer.MAX_VALUE;
        arr = new int[size];
        foot = new boolean[size];
        visited = new int[size+1][5][5];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 5; j++) {
                Arrays.fill(visited[i][j],Integer.MAX_VALUE);
            }
        }
        for (int j = 0; j < 5; j++) {
            Arrays.fill(visited[size][j],Integer.MAX_VALUE);
        }
        System.out.println(go(0,0,0));
    }

    public static int go(int index, int left, int right){
        if(left==right && left!=0){
            return 400000;
        }
        if(index==size){
            return 0;
        }
        if(visited[index][left][right]!=Integer.MAX_VALUE){
            return visited[index][left][right];
        }
        int next = arr[index];
        visited[index][left][right] =
                Math.min(go(index+1,next,right)+count(left,next),
                go(index+1,left,next)+count(right,next));
        return visited[index][left][right];
    }

    public static int count(int cur, int next){

        if(cur == 0){
            return 2;
        }else if(cur == next){
            return 1;
        }else if(Math.abs(cur-next)==2){
            return 4;
        }else{
            return 3;
        }

    }

}
