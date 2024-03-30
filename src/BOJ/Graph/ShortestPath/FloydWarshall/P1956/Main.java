package BOJ.Graph.ShortestPath.FloydWarshall.P1956;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V,E, min;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V+1][V+1];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < V+1; i++) {
            Arrays.fill(map[i],10000000);
            map[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==b){
                min = Math.min(min, c);
            }
            map[a][b] = c;
        }

        for (int k = 1; k < V+1; k++) {
            for (int j = 1; j < V+1; j++) {
                if(j==k) continue;
                for (int i = 1; i < V+1; i++) {
                    if(i==j || i==k) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k]+ map[k][j]);
                }
            }
        }

        for (int i = 1; i < V+1; i++) {
            for (int j = i+1; j < V+1; j++) {
                min = Math.min(min, map[i][j]+map[j][i]);
            }
        }
        System.out.println(min>=10000000?"-1":min);

    }


}