package BOJ.BruteForce.BackTracking.Silver.P15654;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static ArrayList<Integer> selected;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        visited = new boolean[N];
        selected = new ArrayList<>();
        arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        goNext(0);
        System.out.println(sb.toString());
    }

    public static void goNext(int index){
        if(index == M){
            printSelected();
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                visited[i] = true;
                selected.add(arr[i]);
                goNext(index+1);
                selected.remove(index);
                visited[i] = false;
            }
        }
    }

    public static void printSelected(){
        for(int cur: selected){
            sb.append(cur+" ");
        }
        sb.append("\n");
    }
}
