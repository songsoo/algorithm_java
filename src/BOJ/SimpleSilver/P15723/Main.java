package BOJ.SimpleSilver.P15723;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N = 26;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws Exception{

        arr = new ArrayList[26];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = st.nextToken().charAt(0)-97;
            st.nextToken();
            int b = st.nextToken().charAt(0)-97;
            arr[a].add(b);
        }

        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = st.nextToken().charAt(0)-97;
            st.nextToken();
            int b = st.nextToken().charAt(0)-97;
            System.out.println(dfs(a,b)?"T":"F");
        }
    }

    public static boolean dfs(int cur, int findNum){
        if(cur==findNum){
            return true;
        }
        for(int next: arr[cur]){
            if(dfs(next, findNum)){
                return true;
            }
        }
        return false;
    }
}
