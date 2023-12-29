package BOJ.SimpleSilver.P1004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int result = 0;

            int[] start, end;
            start = new int[2];
            end = new int[2];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            int boundaryCount = Integer.parseInt(bf.readLine());

            for (int i = 0; i < boundaryCount; i++) {
                st =  new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                //둘 다 안에 있거나 둘 다 밖에 있으면 x
                boolean isStartIn = isIn(start[0],start[1],x,y,r);
                boolean isEndIn = isIn(end[0],end[1],x,y,r);

                if(isStartIn!=isEndIn){
                    result++;
                }

            }
            System.out.println(result);

        }
    }

    public static boolean isIn(int x1, int y1, int x2, int y2, int r){

        double dist = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        return(dist<r);
    }
}
