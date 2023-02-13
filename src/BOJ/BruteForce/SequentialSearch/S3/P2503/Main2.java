package BOJ.BruteForce.SequentialSearch.S3.P2503;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int N, result,count;
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
        ans = new int[3];
        visited = new boolean[10];
        result = 0;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(bf.readLine());
            int score = Integer.parseInt(st.nextToken());

            scores[i][2] = score%10;
            scores[i][0] = score/100;
            scores[i][1] = (score/10)%10;
            strike[i] = Integer.parseInt(st.nextToken());
            ball[i] = Integer.parseInt(st.nextToken());

        }

        dfs(0);

        System.out.println(result);

    }

    public static void dfs(int round){


        // round가 N일 경우 return
        // 남은 AnsCount가 0일 때는 그냥 ++
        // 남은 AnsCount가 ZeroVisitCount보다 적을땐 조합 활용

        int prev=0;
        if(round==N){
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

        // 스트라이크가 1 이상이면
            // 스트라이크 개수 1 빼고
            // 각 번호의 스트라이크 대입하고 다음으로 넘어가기
                // 각 번호의 위치 previous에 저장
                // 이 때 이미 해당 자리가 차있거나 이미 사용한 번호인데 위치가 다르면 X
                // Visit 확인하고 Visit했으면 continue;
                // Visit은 previous가 0이었을 경우에만 true
                // 해당 자리가 비어있거나 이미 사용한 번호인데 위치가 같으면 dfs(round)
                // previous 0이면 visit false
            //스트라이크 개수 1 다시 더하기
        // 볼이 1 이상이면
            // 볼 개수 1 빼고
            // 각 번호마다
                // 각 위치마다
                    // 각 번호의 위치 previous에 저장
                    // 이 때 이미 해당 자리가 차있거나 이미 사용한 번호인데 위치가 다르면
                    // Visit 확인하고 Visit했으면 continue;
                    // Visit은 previous가 0이었을 경우에만 true
                    // 해당 자리가 비어있거나 이미 사용한 번호인데 위치가 같으면 dfs(round)
                    // 위 끝나고 previous 0이면 visit false
            // 볼 개수 1 다시 더하기
        // 스트라이크, 볼 모두 없으면
            // 모든 번호 visit을 true로 설정하고
            // 다음 라운드로 넘어감
            // visit true로 한 것들 다시 false로 변경


        // 체크인

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