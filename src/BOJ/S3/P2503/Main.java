package BOJ.S3.P2503;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, result;
    static int[][] scores;
    static int[] strike, ball;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\S3\\P2503\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        scores = new int[N][3];
        strike = new int[N];
        ball = new int[N];
        ans = new int[N];
        visited = new boolean[10];
        result = 0;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(bf.readLine());
            int score = Integer.parseInt(st.nextToken());

            scores[i][0] = score%10;
            scores[i][1] = score/100;
            scores[i][2] = (score/10)%10;
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());

        }

        dfs(0);

        System.out.println(result);

    }

    public static void dfs(int round){

        //round가 N이 되면 종료
        if(round==N){
            System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
            if(getZeroAnsCount()==0){
                result++;
            }else if(getZeroAnsCount()>getZeroVisitCount()){

            }else{
                int sum = 1;
                for (int i = 0; i < getZeroAnsCount(); i++) {
                    sum *= (getZeroVisitCount() - i);
                }
                result += sum;
            }
            return;
        }
        //strike 먼저 확인, strike가 1이상이면 strike 1 빼고
        if(strike[round]>=1){
            strike[round]--;
            for (int i = 0; i < 3; i++) {
                //각각의 위치에 각각의 숫자를 넣고 dfs 돌기
                //넣을 수 없는 상황 (해당 위치가 visited고 자신 숫자가 아니면)
                if(visited[scores[round][i]]){
                    continue;
                }
                int prev = ans[i];
                if(ans[i]==0){
                    visited[scores[round][i]] = true;
                    ans[i]= scores[round][i];
                    dfs(round);
                }else if(ans[i]==scores[round][i]){
                    ans[i]= scores[round][i];
                    dfs(round);
                }else{
                    strike[round]++;
                    return;
                }

                if(prev==0){
                    visited[scores[round][i]] = false;
                }
                ans[i] = prev;
            }
            strike[round]++;
            //다시 strike 1 다시 추가
        }else if(ball[round]>=1){
            ball[round]--;
            for (int i = 0; i < 3; i++) {
                //각각의 위치에 각각의 숫자를 넣고 dfs 돌기
                //넣을 수 없는 상황 (해당 위치가 visited고 자신 숫자가 아니면)
                for (int j = 0; j < 3; j++) {
                    if(j==i || visited[scores[round][i]]){
                        continue;
                    }
                    int prev = ans[j];
                    if(ans[j]==0){
                        visited[scores[round][i]] = true;
                        ans[j]= scores[round][i];
                        dfs(round);
                    }else if(ans[j]==scores[round][i]){
                        ans[j]= scores[round][i];
                        dfs(round);
                    }else{
                        ball[round]++;
                        return;
                    }
                    if(prev ==0 ){
                        visited[scores[round][i]] = false;

                    }
                    ans[j] = prev;
                }

            }
            //다시 strike 1 다시 추가
            ball[round]++;
        }

        //strike다 돌고 나면 ball 확인, ball이 1 이상이면 ball 1 빼고
        //각각의 숫자를 가능한 위치에 다 넣고 dfs 돌기
        //모두 확인 후 다시 ball 1 추가


        //strike ball 모두 확인 했으면 다음 라운드 돌기

        dfs(round+1);
    }

    public static int getZeroAnsCount(){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if(ans[i]==0){
                sum++;
            }
        }
        return sum;
    }
    public static int getZeroVisitCount(){
        int sum = 0;
        for (int i = 0; i <9; i++) {
            if(!visited[i]){
                sum++;
            }
        }
        return sum;
    }
}