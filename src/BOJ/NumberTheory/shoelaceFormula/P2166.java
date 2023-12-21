package BOJ.NumberTheory.shoelaceFormula;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2166 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            queue.add(new Point(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken())));
        }
        queue.add(queue.peek());

        long sum1 = 0L;
        long sum2 = 0L;
        Point cur = queue.poll();
        Point prev;
        while(!queue.isEmpty()){
            prev = cur;
            cur = queue.poll();
            sum1 += cur.x * prev.y;
            sum2 += cur.y * prev.x;
        }
        System.out.printf("%.1f%n", Math.abs((sum1-sum2)/2D));
    }

}
class Point{
    long x;
    long y;
    Point(long x, long y){
        this.x = x;
        this.y = y;
    }
}
