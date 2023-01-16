package SWEA.D5.P1248;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] vertex, loc;
    static boolean[] visited;
    static int T,V,E,V1,V2,L1,L2;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SWEA/D5/P1248/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 1; t < T+1; t++) {

            st = new StringTokenizer(bf.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            V1 = Integer.parseInt(st.nextToken());
            V2 = Integer.parseInt(st.nextToken());

            // 정점 번호로 그 위치를 찾는 배열
            loc = new int[(V+1)*2];
            // 위치로 정점 번호를 찾는 배열
            vertex = new int[(V+1)*2];
            visited = new boolean[(V+1)*2];
            vertex[1] = 1;
            loc[1] = 1;
            visited[1] = true;

            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int Child = Integer.parseInt(st.nextToken());
                int ChildLoc = visited[loc[parent]*2]? loc[parent]*2+1 : loc[parent]*2;
                loc[ChildLoc] = Child;
                visited[ChildLoc] = true;
                L1 = V1 == Child ? ChildLoc : L1;
                L2 = V1 == Child ? ChildLoc : L2;
            }

        }

    }

    public static boolean isChild(int par, int chi){
        int diff = par/chi;
        return true;
    }
}
