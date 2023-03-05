package SWEA.D4.P1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N,M;
    static ArrayList<Integer>[] sons;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\SWEA\\D4\\P1238\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10 ; test_case++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sons = new ArrayList[101];
            visited = new boolean[101];
            for (int i = 0; i < 101; i++) {
                sons[i] = new ArrayList<>();
            }

            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                sons[from].add(to);
            }
            System.out.println("#"+test_case+" "+bfs(M));

        }


    }
    public static int bfs(int x){
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int maxNum = x;
        int maxCount = count;
        queue.add(new int[]{x,count});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(maxCount<cur[1]){
                maxCount = cur[1];
                maxNum = cur[0];
            }
            if(maxCount==cur[1]){
                maxNum = Math.max(maxNum,cur[0]);
            }
            for (int i = 0; i < sons[cur[0]].size(); i++) {
                int next = sons[cur[0]].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(new int[]{next, cur[1]+1});
                }
            }
        }
        return maxNum;
    }

}
