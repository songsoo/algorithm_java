package Test;

import java.util.*;
import java.io.*;

public class 세부 {

    static class MyScanner {

        BufferedReader bf;
        StringTokenizer st;

        MyScanner() throws FileNotFoundException {
            System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\Test\\Input.txt"));
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            if (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
    static int N,M,S,E;
    static ArrayList <int[]> edges[];
    static int INF=987654321;
    static int answer = 0;

    public static int Go() throws FileNotFoundException {
        // TODO Auto-generated method stub
        MyScanner sc = new MyScanner();
        N = sc.nextInt();
        M = sc.nextInt();
        S = sc.nextInt();
        E = sc.nextInt();
        edges = new ArrayList[N+1];

        for(int i = 0;i<=N;i++) {
            edges[i] = new ArrayList<int[]>();
        }

        for(int i =0 ;i <M;i++) {
            int  x = sc.nextInt();
            int  y = sc.nextInt();
            int  z = sc.nextInt();
            edges[x].add(new int[] {y,z});
            edges[y].add(new int[] {x,z});
        }

        PriorityQueue <int[]> pq = new PriorityQueue <int[]>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return -(o1[1]-o2[1]);
            }

        });
        boolean v[] = new boolean[N+1];
        int D[] = new int[N+1];
        D[S] = INF;
        pq.add(new int[]{S,0});

        while(!pq.isEmpty()) {
            int now[] = pq.poll();
            if(v[now[0]]) continue;
            v[now[0]] = true;
            for(int i =0 ;i < edges[now[0]].size();i++) {
                int u = edges[now[0]].get(i)[0];
                int w = edges[now[0]].get(i)[1];
                D[u]= Math.max(D[u], Math.min(D[now[0]], w));
                pq.add(edges[now[0]].get(i));
            }
        }

        answer = D[E];
        return (answer);
    }

}