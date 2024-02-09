package BOJ.BruteForce.DFS.Gold.P1068;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arr[];
    static int deleteNode;
    static ArrayList<Integer> start;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new ArrayList[N];
        start = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent==-1){
                start.add(i);
            }else{
                arr[parent].add(i);
            }
        }
        deleteNode = Integer.parseInt(bf.readLine());
        arr[deleteNode].clear();
        int sum = 0;
        for (int startNode : start){
            sum += findLeaf(startNode);
        }
        System.out.println(sum);
    }

    public static int findLeaf(int node){
        if(node == deleteNode){
            return 0;
        }
        if(arr[node].size()==0){
            return 1;
        }else{
            int sum = 0;
            for(int next : arr[node]){
                sum += findLeaf(next);
            }
            return sum==0?1:sum;
        }
    }
}
