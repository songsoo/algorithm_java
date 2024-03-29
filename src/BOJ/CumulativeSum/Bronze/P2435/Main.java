package BOJ.CumulativeSum.Bronze.P2435;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<K;i++){
            int cur = Integer.parseInt(st.nextToken());
            queue.add(cur);
            sum += cur;
        }
        max = Math.max(max, sum);
        for(int i=K; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());
            queue.add(cur);
            sum += cur;
            if(queue.size() > K){
                sum -= queue.poll();
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}
