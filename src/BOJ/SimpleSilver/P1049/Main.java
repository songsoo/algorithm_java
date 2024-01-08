package BOJ.SimpleSilver.P1049;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minPackage = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int packagePrice = Integer.parseInt(st.nextToken());
            int eachPrice = Integer.parseInt(st.nextToken());

            minPackage = Math.min(minPackage, packagePrice);
            minEach = Math.min(minEach,eachPrice);
        }

        int minPrice = 0;
        //Package가 Each보다 싸면 최대한 갯수 맞춘다
        if(minPackage/6<minEach){
            minPrice += (N/6)*minPackage;
            minPrice += Math.min((N%6)*minEach, minPackage);
        }else{
            minPrice += N * minEach;
        }

        System.out.println(minPrice);
    }
}
