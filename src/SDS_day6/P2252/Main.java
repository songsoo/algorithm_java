package SDS_day6.P2252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

// 위상정렬
// 선후 관계가 정의된 그래프 구조에서 사용된다.
// 모든 선후관계도 아니고 몇몇 애들끼리 선후 관계가 나타나있음

// 기본적으로는 정렬이지만 tree 형태로 분기된 상태에서 정렬을 시도한다.
public class Main {
    static int N, M;


    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS_day6/P2252/Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N+1];
        int[] in = new int[N+1];
        for(int i=0;i<N+1;i++){
            adj[i] = new ArrayList<>();
        }

        Queue<Integer> queue = new LinkedList<>();
        // from - to 를 배열에 추가하고 to 진입차수 증가
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            in[to]++;
        }
        // 진입차수 0인 값들 queue에 추가
        for (int i = 1; i < N+1; i++) {
            if(in[i]==0){
                queue.add(i);
            }
        }
        // queue에서 하나씩 꺼내서 다음으로 가는 녀석들 진입차수 -1하고 0인 녀석들 queue에 추가
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");
            for(int to : adj[now]){
                if(--in[to]==0){
                    queue.add(to);
                }
            }
        }


    }

}
