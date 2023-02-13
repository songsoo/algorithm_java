package BOJ.Implement.S4.P1244;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, studentNum;
    static boolean[] switchCond;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S4\\P1244\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        switchCond = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i < N+1; i++) {
            switchCond[i] = st.nextToken().charAt(0)=='0'?false:true;
        }
        int studentNum = Integer.parseInt(bf.readLine());
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());
            if(gender==1){
                boy(switchNum);
            }else{
                girl(switchNum);
            }
        }
        for (int i = 1; i < N+1; i++) {
            System.out.print(switchCond[i]?'1'+" ":'0'+" ");
            if(i%20==0){
                System.out.println();

            }
        }



    }

    public static void boy(int num){
        int step = num;
        while(num<N+1){
            switchCond[num] = !switchCond[num];
            num+=step;
        }
    }

    public static void girl(int num){
        int i=1;
        switchCond[num] = !switchCond[num];
        while(num-i>=1 && num+i<N+1){
            if(switchCond[num-i]!=switchCond[num+i]){
                break;
            }
            switchCond[num-i] = !switchCond[num-i];
            switchCond[num+i] = !switchCond[num+i];
            i++;
        }
    }


}
