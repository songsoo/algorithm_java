package SDS_day7.P2458;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int N,M;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS_day7/P2458/Input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N+1];
        List<Integer>[] parent = new ArrayList[N+1];
        int[] inDeg = new int[N+1];
        boolean[] vst = new boolean[N+1];
        int[] bigger = new int[N+1];
        int[] smaller = new int[N+1];

        int in,out;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(bf.readLine()," ");

            in = Integer.parseInt(st.nextToken());
            out = Integer.parseInt(st.nextToken());

            adj[in].add(out);
            inDeg[out]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<M+1;i++){
            if(inDeg[i]==0){
                queue.add(i);
                vst[i] = true;
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            Loop1 :
            for (int i = 0; i < adj[cur].size(); i++) {
                int next = inDeg[adj[cur].get(i)];
                if(next==0){
                    inDeg[next]--;
                    if(vst[next]==false){
                        queue.add(next);
                        vst[next] = true;
                    }
                    if(bigger[cur]==0){
                        bigger[next]++;
                    }else {
                        bigger[next] += bigger[cur];
                    }
                }
            }
        }


    }
}
























