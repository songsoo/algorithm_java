package SWEA.Test.P2112;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

    static int D,W,K,min;
    static int arr[][];
    static char visited[];
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\Test\\Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(bf.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            min = K+1;
            visited = new char[D];
            arr = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            goNext(0,0);

            System.out.print("#"+test_case+" "+min+"\n");
        }
    }

    public static void goNext(int cnt, int cur){

        if(cnt==K || cur==D){
            if(isChecked()){
                System.out.println(Arrays.toString(visited));
                min =Math.min(min,cnt);
            }
            return;
        }
        visited[cur] = '0';
        goNext(cnt,cur+1);

        visited[cur] = '1';
        goNext(cnt+1,cur+1);

        visited[cur] = '2';
        goNext(cnt+1,cur+1);

        visited[cur] = '0';
    }
    public static boolean isChecked(){
        Loop1:
        for (int i = 0; i < W; i++) {
            int cur;

            if(visited[0]=='0'){
                cur = arr[0][i];
            }else if(visited[0]=='1'){
                cur = 0;
            }else{
                cur = 1;
            }

            int sum=1;

            for (int j = 1; j < D; j++) {
                int tmp = arr[j][i];
                if(visited[j]=='1'){
                    tmp = 0;
                }else if(visited[j]=='2'){
                    tmp = 1;
                }
                if(tmp!=cur){
                    cur = tmp;
                    sum=1;
                }else{
                    sum++;
                }
                if(sum>=K){
                    continue Loop1;
                }
            }
            return false;
        }
        return true;
    }
    public static void printArr(){

    }

}