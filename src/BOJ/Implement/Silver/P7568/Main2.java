package BOJ.Implement.Silver.P7568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Info> arr = new ArrayList<>();
        int[] rank = new int[N];
        Arrays.fill(rank, 1);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < N; i++) {
            Info one = arr.get(i);
            for (int j = i+1; j < N; j++) {
                Info two = arr.get(j);
                if(one.compareTo(two)>0){
                    rank[i]++;
                }else if(one.compareTo(two)<0){
                    rank[j]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rank[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
class Info implements Comparable<Info>{
    int height;
    int weight;

    public Info(int weight, int height) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Info o) {
        if(o.height > this.height && o.weight > this.weight){
            return 1;
        }else if(o.height < this.height && o.weight < this.weight){
            return -1;
        }else{
            return 0;
        }
    }
}