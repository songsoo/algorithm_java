package BOJ.BruteForce.SequentialSearch.S1.P2615;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] omok;
    static int[] moveX={1,0,1,-1},moveY={0,1,1,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S1\\P2615\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        omok = new int[21][21];
        for (int i = 0; i < 21; i++) {
            Arrays.fill(omok[i],-1);
        }

        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < 20; j++) {
                omok[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        loop:
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if((omok[i][j]==2 || omok[i][j]==1)&&isFinished(i,j)){
                    System.out.println(omok[i][j]+"\n"+i+" "+j);
                    System.exit(0);
                }
            }
        }
        System.out.println("0");
    }

    public static boolean isFinished(int x, int y){
        int value = omok[x][y];
        loop:
        for (int d = 0; d < 4; d++) {
            int curX = x;
            int curY = y;
            int i = 0;
            for (; i < 4; i++) {
                curX+=moveX[d];
                curY+=moveY[d];
                if(omok[curX][curY]!=value || omok[curX][curY]==-1){
                    continue loop;
                }
            }
            if(i==4){
                if(omok[curX+moveX[d]][curY+moveY[d]]!=value && omok[x-moveX[d]][y-moveY[d]]!=value){
                    return true;
                }
            }
        }
        return false;
    }
}