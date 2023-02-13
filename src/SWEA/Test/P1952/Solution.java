package SWEA.Test.P1952;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] prices, counts;

    static int[] schedules;
    static boolean[] visited;
    static int min;
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\SWEA\\P1952\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            visited= new boolean[12];
            prices = new int[4];
            counts=new int[4];
            schedules = new int[12];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 4; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            min = prices[3];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 12; i++) {
                schedules[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0);
            System.out.println("#"+test_case+" "+min);

        }
    }
    public static void dfs(int i){
        if(i>=12){
            min = Math.min(min,counts[0]*prices[0]+counts[1]*prices[1]+counts[2]*prices[2]);
            return;
        }
        visited[i]=true;
        for (int j = 0; j < 3; j++) {
            if(j==0){
                counts[0]+=schedules[i];
                dfs(i+1);
                counts[0]-=schedules[i];
            }else if(j==1){
                counts[1]+=1;
                dfs(i+1);
                counts[1]-=1;
            }else if(j==2){
                counts[2]+=1;
                dfs(i+3);
                counts[2]-=1;
            }
        }
    }
}
