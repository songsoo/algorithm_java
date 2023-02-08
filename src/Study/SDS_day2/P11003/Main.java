package Study.SDS_day2.P11003;

import java.io.*;
import java.util.*;

public class Main {

    static int N, L;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day2/P11003/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Number> PQ = new PriorityQueue<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            PQ.add(new Number(i,value));
            while(PQ.peek().key<=i-L){
                PQ.poll();
            }
            bw.write(PQ.peek().value+" ");
        }
        bw.close();
    }
}
class Number implements Comparable<Number>{
    int key;
    int value;
    Number(int newKey, int newValue){
        key = newKey;
        value = newValue;
    }
    @Override
    public int compareTo(Number o) {
        return this.value-o.value;
    }
}