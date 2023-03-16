package BOJ.Implement.B3.P27736;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChoongAngA {
    static int N, point, abstent;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        point = 0;
        abstent = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            point += cur;
            abstent = cur==0?abstent+1:abstent;
        }

        if(((N+1)/2)<=abstent){
            System.out.println("INVALID");
        }else if(point<=0){
            System.out.println("REJECTED");
        }else if(point>0){
            System.out.println("APPROVED");
        }

    }
}
