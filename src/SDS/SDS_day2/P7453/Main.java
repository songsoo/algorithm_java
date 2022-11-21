package SDS.SDS_day2.P7453;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] A,B,C,D;
    static int T;
    static long result;
    static int[] left,right;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SDS.SDS_day2/P7453/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());
        result = 0;
        left = new int[T*T];
        right = new int[T*T];
        A = new int[T];
        B = new int[T];
        C = new int[T];
        D = new int[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                left[i*T+j]=(A[i]+B[j]);
                right[i*T+j]=(C[i]+D[j]);
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int pta=0, ptb=right.length-1;
        while(true){
            int curA = left[pta];
            int curB = right[ptb];
            if(curA+curB==0){
                int countA = 0;
                int countB = 0;
                while(pta<left.length && left[pta]==curA){
                    pta++;
                    countA++;
                }
                while(ptb>=0 && right[ptb]==curB){
                    ptb--;
                    countB++;
                }
                result += (long) countA * countB;

            }else if(curA+curB>0){
                ptb--;
            }else{
                pta++;
            }
            if(pta>=left.length || ptb<0){
                break;
            }


        }

        System.out.println(result);

    }
}