package Test.Later;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1107 {
    static int N, M, min;
    static boolean[] broken;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        broken = new boolean[10];
        min = Math.abs(N-100);
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            broken[Integer.parseInt(st.nextToken())] = true;
        }
        perm(7,0,1,0);
        perm(0,0,0,0);
        System.out.println(min);
    }
    public static void perm(int index, int a, int count, int zero){
        if(index==7){
            if(zero>0){
                count -= zero;

            }
            if(a==0 && count ==0){
                return;
            }
            min = Math.min(min, count+Math.abs(N-a));
            return;
        }
        for (int i = 0; i < 10; i++) {
            if(!broken[i]){
                perm(index+1,a+(int)Math.pow(10,index) * i,count+1,i==0?zero+1:0);
            }
        }
    }

}
