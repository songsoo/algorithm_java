package SWEA.Test.P4008;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] ops,nums;
    static boolean[] visited;
    static int Maxresult,Minresult,N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\Test\\P4008\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            ops= new int[4];
            Maxresult = Integer.MIN_VALUE;
            Minresult = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                ops[i] = Integer.parseInt(st.nextToken());
            }
            nums = new int[N];
            visited = new boolean[N];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            perm(nums[0],0);
            System.out.println(Maxresult+" "+Minresult);
            System.out.println("#"+test_case+" "+(Maxresult-Minresult));
        }
    }

    public static void perm(int tot, int cnt){
        //N이 5일 때 cnt가 3까지 들어감
        if(cnt==N-1){
            Maxresult = Math.max(Maxresult,tot);
            Minresult = Math.min(Minresult,tot);
            return;
        }
        if(ops[0]!=0){
            ops[0]--;
            perm(tot+nums[cnt+1],cnt+1);
            ops[0]++;
        }
        if(ops[1]!=0){
            ops[1]--;
            perm(tot-nums[cnt+1],cnt+1);
            ops[1]++;
        }
        if(ops[2]!=0){
            ops[2]--;
            perm(tot*nums[cnt+1],cnt+1);
            ops[2]++;
        }
        if(ops[3]!=0){
            ops[3]--;
            perm(tot/nums[cnt+1],cnt+1);
            ops[3]++;
        }
    }
}
