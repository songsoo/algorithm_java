package BOJ.DivideConquer.S2.P2630;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] papers;
    static int[] nums;
    static int[] moveX={0,0,1,1}, moveY={0,1,0,1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S2\\P2630\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        nums = new int[2];
        papers = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,N);
        System.out.println(nums[0]+"\n"+nums[1]);
    }

    public static void divide(int x, int y, int index){
        if(isSquare(x,y,index)){
            nums[papers[x][y]]++;
        }else{
            for (int i = 0; i < 4; i++) {
                divide(x+moveX[i]*index/2, y+moveY[i]*index/2,index/2);
            }
        }
    }

    public static boolean isSquare(int x, int y, int index){
        int value = papers[x][y];
        for (int i = x; i < x+index; i++) {
            for (int j = y; j < y+index; j++) {
                if(papers[i][j]!=value){
                    return false;
                }
            }
        }
        return true;
    }

}
