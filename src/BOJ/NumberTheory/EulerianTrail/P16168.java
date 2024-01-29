package BOJ.NumberTheory.EulerianTrail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16168 {
    static int V,E;
    static int arr[], parent[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new int[V+1];
        parent = new int[V+1];
        for (int i = 0; i < V+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a]++;
            arr[b]++;
            union(a,b);
        }
        int odd = 0;
        int even = 0;
        boolean flag = true;
        int prev = find(1);
        for (int i = 1; i < V+1; i++) {
            if(arr[i]%2==1){
                odd++;
            }else{
                even++;
            }
            if(prev != find(i)){
                flag = false;
                break;
            }
        }
        // 홀수가 아예없거나 홀수가 2개고 나머지 짝수일 때
        if(odd!=0 && odd!=2){
            flag = false;
        }
        System.out.println(flag?"YES":"NO");
    }
    public static int find(int a){
        if(parent[a] == a){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[Math.min(a,b)] = Math.max(a,b);
        }
    }
}
