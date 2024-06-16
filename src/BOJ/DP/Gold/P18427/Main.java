package BOJ.DP.Gold.P18427;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static ArrayList<Integer>[] students;
    static int[][] arr;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        students = new ArrayList[N];
        arr = new int[N][1001];
        for (int i = 0; i < N; i++) {
            students[i] = new ArrayList<>();
            Arrays.fill(arr[i], -1);
            st = new StringTokenizer(bf.readLine());
            students[i].add(0);
            while(st.hasMoreTokens()){
                students[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(dfs(0, 0));

    }
    public static int dfs(int idx, int sum){
        if(idx==N){
            if(sum == H){
                return 1;
            }else{
                return 0;
            }
        }
        int poss = 0;
        for(int curHeight : students[idx]){
            if(curHeight + sum > H){
                continue;
            }
            if(arr[idx][curHeight+sum]==-1){
                int next = dfs(idx+1, curHeight+sum)%10007;
                poss += next;
                arr[idx][curHeight+sum] = next;
            }else{
                poss += arr[idx][curHeight+sum]%10007;
            }
        }
        return poss%10007;
    }
}
