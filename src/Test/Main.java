package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<int[]> dots;
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        dots = new ArrayList<>();
        int sum = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        dots.add(new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        st = new StringTokenizer(bf.readLine());
        dots.add(new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});

        int prev = getDist(0, 1);
        sum += prev;
        int diffMax = 0;

        for (int i = 2; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            dots.add(new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            int cur = getDist(i-1, i);
            sum += getDist(i-1, i);
            diffMax = Math.max(diffMax, prev+cur-getDist(i-2, i));
            prev = cur;
        }

        System.out.println(sum - diffMax);

    }

    public static int getDist(int i, int j){
        int[] dotOne = dots.get(i);
        int[] dotTwo = dots.get(j);
        return Math.abs(dotOne[0]-dotTwo[0])+ Math.abs(dotOne[1]-dotTwo[1]);
    }
}
