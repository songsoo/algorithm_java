package BOJ.BruteForce.BackTracking.Silver.P15566;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] frogs;
    static ArrayList<Integer>[] isConnected;
    static int[][] connectedSubject;
    static int[] visited;
    static ArrayList<Integer>[] lotus;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        frogs = new int[N+1][7];
        isConnected = new ArrayList[N+1];
        connectedSubject = new int[N+1][N+1];
        lotus = new ArrayList[N+1];

        for (int i = 1; i < N+1; i++) {
            lotus[i] = new ArrayList<>();
            isConnected[i] = new ArrayList<>();
        }

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            frogs[i][1] = Integer.parseInt(st.nextToken());
            frogs[i][2] = Integer.parseInt(st.nextToken());
            frogs[i][3] = Integer.parseInt(st.nextToken());
            frogs[i][4] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==b){
                frogs[i][5] = a;
                frogs[i][6] = -1;
                lotus[a].add(i);
            }else{
                frogs[i][5] = a;
                frogs[i][6] = b;
                lotus[a].add(i);
                lotus[b].add(i);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int subject = Integer.parseInt(st.nextToken());
            isConnected[a].add(subject);
            isConnected[b].add(subject);
            connectedSubject[a][b] = subject;
            connectedSubject[b][a] = subject;
        }

        // 해당 연꽃에 들어가있는 개구리
        visited = new int[N+1];
        Arrays.fill(visited, -1);

        StringBuilder sb = new StringBuilder();
        if(dfs(1)){
            sb.append("YES").append("\n");
            for (int i = 1; i < N+1; i++) {
                sb.append(visited[i]+" ");
            }
        }else{
            sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }
    // 개구리를 0번부터 N-1번까지 돌면서
    // 해당 개구리의 연꽃을 선택해서 입력한다.
    public static boolean dfs(int index){
        if(index==N+1){
            return true;
        }
        // 해당 개구리가 선택한 연꽃마다 실행
        for(int i = 5 ; i < 7;i++){
            int curLotus = frogs[index][i];
            // 개구리가 하나만 선택한 놈이거나, 이미 방문한 연꽃은 break
            if(curLotus == -1 || visited[curLotus] != -1){
                break;
            }
            // 다음 연꽃을 확인해서 연결할 수 없다면 취소
            boolean flag = true;
            for(int connectedLotus: isConnected[curLotus]){
                int subject = connectedSubject[curLotus][connectedLotus];
                int nextFrog = visited[connectedLotus];
                if(nextFrog==-1){
                    continue;
                }
                if(frogs[index][subject] != frogs[nextFrog][subject]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                visited[curLotus] = index;
                if(dfs(index+1)){
                    return true;
                }
                visited[curLotus] = -1;
            }
        }
        return false;
    }
}
