package BOJ.DivideConquer.Silver.P1992;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb;
    static int[] moveX={0,0,1,1},moveY={0,1,0,1};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\DivideConquer\\S1\\P1992\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char[] tmp = bf.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]+"");
            }
        }
        dfs(0,0,N);

        System.out.println(sb.toString());

    }
    public static void dfs(int x, int y, int index){
        if(black(x,y,index)){
            sb.append("1");
            return;
        }
        if(white(x,y,index)){
            sb.append("0");
            return;
        }
        if(index==1){
            sb.append("0");
            return;
        }
        sb.append("(");
        for (int i = 0; i < 4; i++) {
            dfs(x+(moveX[i]*index/2),y+(moveY[i]*index/2),index/2);
        }
        sb.append(")");
    }
    public static boolean black(int x,int y, int index){
        for (int i = x; i < x+index; i++) {
            for (int j = y; j < y+index; j++) {
                if(arr[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean white(int x,int y, int index){
        for (int i = x; i < x+index; i++) {
            for (int j = y; j < y+index; j++) {
                if(arr[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }

}
