package BOJ.SimpleSilver.P1022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int size=10000;
    static int rmin, rmax, cmin, cmax;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int R1 = 0;
        int R2 = Math.abs(r2-r1);
        int C1 = 0;
        int C2 = Math.abs(c2-c1);

        cmin = -size/2;
        cmax = size/2;
        rmin = -size/2;
        rmax = size/2;

        int[] moveR = {0,-1,0,1}, moveC = {-1,0,1,0};
        int[] moveCmax = {0,0,0,-1}, moveCmin ={0,1,0,0}, moveRmax={-1,0,0,0}, moveRmin={0,0,1,0};
        arr = new int[R2+1][C2+1];

        int moveIndex = 0;
        int i = size/2;
        int j = size/2;
        int count = (size+1) * (size+1);
        int countMax = 0;

        while(true){

            if(i>=r1 && i<=r2 && j>=c1 && j<=c2){
                arr[i-r1][j-c1] = count;
                countMax = Math.max(countMax,count);
            }

            count--;

            if(i==0 && j==0){
                break;
            }

            if(!check(i+moveR[moveIndex], j+moveC[moveIndex])){
                cmin += moveCmin[moveIndex];
                cmax += moveCmax[moveIndex];
                rmin += moveRmin[moveIndex];
                rmax += moveRmax[moveIndex];
                moveIndex = (moveIndex+1)%4;
            }

            i += moveR[moveIndex];
            j += moveC[moveIndex];
        }

        StringBuilder sb = new StringBuilder();

        int hmm = (int)Math.log10(countMax)+1;
        for (int k = 0; k < R2+1; k++) {
            for (int l = 0; l < C2+1; l++) {
                sb.append(String.format("%"+hmm+"d ",arr[k][l]));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean check(int i, int j){
        if(i<rmin || i>rmax || j<cmin || j>cmax){
            return false;
        }
        return true;
    }
}
