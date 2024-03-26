package BOJ.BruteForce.BFS.Gold.P18513;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static HashSet<Integer> homeLoc;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        homeLoc = new HashSet<>();

        st = new StringTokenizer(bf.readLine());
        Queue<int[]> queue = new ArrayDeque<>();
        long result = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int curHome = Integer.parseInt(st.nextToken());
            homeLoc.add(curHome);
            queue.add(new int[]{curHome-1, -1, 1});
            queue.add(new int[]{curHome+1, 1, 1});
        }

        while(!queue.isEmpty() && cnt < K){

            int[] cur = queue.poll();
            if(homeLoc.contains(cur[0])){
                continue;
            }
            homeLoc.add(cur[0]);
            result += cur[2];
            cnt++;
            int nextLoc = cur[0] + cur[1];
            queue.add(new int[] {nextLoc, cur[1], cur[2]+1});

        }

        System.out.println(result);

    }

}