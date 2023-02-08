package Study.SDS_day7.P2458;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//깊이 우선 탐색 각 정점에 대해 작업해서
//해당 정점 아래에 있는 정점들에게 incount를 증가
//outcount는 dfs를 반복하면서 아래에 있는 정점들이 자신 밑에 있는 정점 수를 리턴하여 최종 return된 값들 끼리 더한다.
//정석은 플로이드 와셜로 푸는 것
public class Answer {

    static int N,M;
    static int[] inCount, outCount;
    static ArrayList<Integer>[] adj;
    static boolean visited[];
    public static int dfs(int cur){


        int nowOut = 1;
        if(adj[cur].size()==0){
            return nowOut;
        }
        for(int i=0;i<adj[cur].size();i++){
            int next = adj[cur].get(i);

            if(!visited[next]) {
                inCount[next]++;
                nowOut += dfs(next);
                visited[next] = true;
            }
        }

        return nowOut;
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SDS.SDS_day7/P2458/Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            adj[i] = new ArrayList<>();
        }
        inCount = new int[N+1];
        outCount = new int[N+1];

        int in,out;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine()," ");

            in = Integer.parseInt(st.nextToken());
            out = Integer.parseInt(st.nextToken());

            adj[in].add(out);
        }

        // 각 정점을 돌면서 dfs확인
        for(int i=1;i<N+1;i++){
            visited = new boolean[N+1];
            outCount[i] = dfs(i)-1;
        }
        int result=0;
        for(int i=1;i<N+1;i++){
            if(inCount[i]+outCount[i]==N-1){
                result++;
            }
        }
        System.out.println(result);



    }


}
