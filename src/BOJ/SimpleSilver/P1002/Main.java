package BOJ.SimpleSilver.P1002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double dist = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
            // 완전 같은 원
            if(x1==x2 && y1==y2 && r1==r2){
                System.out.println(-1);
            }
            // 큰 원 안에 작은 원
            else if(Math.max(r1,r2)>dist+Math.min(r1,r2)){
                System.out.println(0);
            }
            // 큰 원 안에 작은 원
            else if(Math.max(r1,r2)==dist+Math.min(r1,r2)){
                System.out.println(1);
            }
            //
            else if(dist>r1+r2){
                System.out.println(0);
            }else if(dist==r1+r2){
                System.out.println(1);
            }else if(dist<r1+r2){
                System.out.println(2);
            }
        }

    }
}
