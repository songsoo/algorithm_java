package BOJ.G5.P2212;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,K;
    static HashSet<Integer> sensorsh;
    static PriorityQueue<Integer> sensors;
    static PriorityQueue<distance> distances;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\G5\\P2212\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        st  = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(st.nextToken());
        st  = new StringTokenizer(bf.readLine());

        sensorsh = new HashSet();
        sensors = new PriorityQueue<>();
        distances = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            sensorsh.add(Integer.parseInt(st.nextToken()));
        }

        for(int a : sensorsh){
            sensors.add(a);
        }

        while(true) {
            int a = sensors.poll();
            if (sensors.isEmpty()) {
                break;
            }
            int b = sensors.peek();
            distances.add(new distance(a, b));
        }

        while(!distances.isEmpty()){

            System.out.println(distances.poll());



        }

    }


}
class distance implements Comparable<distance>{

    int start;
    int end;
    int value;

    public distance(int start, int end) {
        this.start = start;
        this.end = end;
        this.value = end - start;
    }

    @Override
    public int compareTo(distance o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "distance{" +
                "start=" + start +
                ", end=" + end +
                ", value=" + value +
                '}';
    }
}
