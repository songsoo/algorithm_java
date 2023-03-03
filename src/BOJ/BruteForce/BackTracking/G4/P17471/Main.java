package BOJ.BruteForce.BackTracking.G4.P17471;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, result;
    static boolean[] visited;
    static int[] population;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        population = new int[N+1];
        graph = new ArrayList[N+1];
        result = Integer.MAX_VALUE;

        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
            graph[i].add(i);
            for (int j = 1; j <= num; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        subset(1);
        System.out.println(result==Integer.MAX_VALUE?-1:result);
    }
    public static void subset(int index){
        if(index==N+1){
            int res = check();
            result = Math.min(result, res);
            return;
        }
        subset(index+1);
        visited[index] = true;
        subset(index+1);
        visited[index] = false;
    }
    public static int check(){
        // team 하나 선택 bfs
        // 다른 team 하나 선택 bfs
        boolean red = false;
        int[] redInf = new int[2];
        boolean blue = false;
        int[] blueInf = new int[2];

        for (int i = 1; i < N+1; i++) {
            if(visited[i]==true && red ==false){
                red =true;
                redInf = bfs(i);
            }else if(visited[i]==false && blue == false){
                blue = true;
                blueInf = bfs(i);
            }

            if(red==true && blue==true){
                if((redInf[0] + blueInf[0])==N){
                    return Math.abs(redInf[1] - blueInf[1]);
                }else{
                    return Integer.MAX_VALUE;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int[] bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        int count = 1;
        int result= population[x];
        boolean[] thisVisited = new boolean[N+1];
        thisVisited[x] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : graph[cur]){
                if(!thisVisited[next] && visited[x]==visited[next]){
                    thisVisited[next] = true;
                    queue.add(next);
                    count++;
                    result += population[next];
                }
            }
        }
        return new int[]{count, result};
    }
}
