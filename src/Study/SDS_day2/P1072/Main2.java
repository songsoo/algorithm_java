package Study.SDS_day2.P1072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static long X,Y,Z,result;


    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SDS.SDS_day2/P1072/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Z = (Y*100/X);
        bs(0,X);
        if(result > X){
            result = -1;
        }
        System.out.println(result);

    }

    public static void bs(long min, long max){
        if(min>max){
            result = (min+max)/2+1;
            return;
        }

        long mid = (min+max)/2;

        if((Y+mid)*100/(X+mid)>Z){
            bs(min,mid-1);
        }else if ((Y+mid)*100/(X+mid)==Z){
            bs(mid+1,max);
        }

    }

}
