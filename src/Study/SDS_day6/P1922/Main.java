package Study.SDS_day6.P1922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//크루스칼 알고리즘
//edge를 가장 낮은 비용부터 sorting해서
//하나씩 넣어보고 v-1개까지 추가하기
//cycle이 생기면 그건 넣지 않는다.

public class Main {

    static int N,M,numOfEdge=1,sumOfEdge=0;
    static int parent[];

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day6/P1922/Input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        PriorityQueue<line> lines = new PriorityQueue<>();

        parent = new int[N+1];
        for(int i=0;i<N+1;i++){
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            line tmp = new line(a,b,c);
            lines.add(tmp);
        }


        while(numOfEdge<N){
            line now = lines.poll();
            if(!isCycle(now.a,now.b)){
                System.out.println("add "+now.c);
                parent[find(parent[now.b])] = now.a;
                numOfEdge++;
                sumOfEdge+=now.c;
            }
        }
        System.out.println(sumOfEdge);


    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }

    public static boolean isCycle(int a, int b){
        a = find(a);
        b = find(b);

        if(a==b){
            return true;
        }else{
            System.out.println(a+", "+b);
            return false;
        }
    }


}
class line implements Comparable<line>{
    int a;
    int b;
    int c;

    line(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return Integer.toString(c);
    }

    @Override
    public int compareTo(line o) {
        if(c<o.c){
            return -1;
        }else if(c == o.c){
            return 0;
        }else{
            return 1;
        }

    }
}
