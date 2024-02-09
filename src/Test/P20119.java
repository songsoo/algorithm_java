package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class P20119 {
    static int N, M, L, count = 0;
    static ArrayList<Integer>[] recipe;
    static ArrayList<Integer> result;
    static boolean[] visited;
    static int[] inDegree;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recipe = new ArrayList[N+1];
        result = new ArrayList<>();
        inDegree = new int[N+1];
        visited = new  boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            recipe[i] = new ArrayList();
            inDegree[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int cur = Integer.parseInt(st.nextToken());
                queue.add(cur);
            }
            int num = Integer.parseInt(st.nextToken());
            if(inDegree[num] == -1){
                inDegree[num] = 0;
            }
            while(!queue.isEmpty()){
                int in = queue.poll();
                if(!recipe[in].contains(num)){
                    recipe[in].add(num);
                    inDegree[num]++;
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            System.out.println(i+" "+recipe[i].toString()+" "+inDegree[i]);
        }

        L = Integer.parseInt(bf.readLine());
        Queue<Integer> potionList = new LinkedList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < L; i++) {
            int cur = Integer.parseInt(st.nextToken());
            potionList.add(cur);
            inDegree[cur] = 0;
        }

        while(!potionList.isEmpty()){
            int cur = potionList.poll();
            visited[cur] = true;
            result.add(cur);
            count++;
            for(int next : recipe[cur]){
                if(!visited[next] && --inDegree[next]==0){
                    potionList.add(next);
                }
            }
        }

        Collections.sort(result);
        // potion 배열에 있는거 하나씩 빼면서 indegree 낮추기

        StringBuilder sb = new StringBuilder();
        sb.append(count+"\n");
        for(int res : result){
            sb.append(res+" ");
        }
        System.out.println(sb.toString());

    }
}
class grad{
    // 결합물 번호
    int comp;
    int order;

    public grad(int comp, int order) {
        this.comp = comp;
        this.order = order;
    }
}