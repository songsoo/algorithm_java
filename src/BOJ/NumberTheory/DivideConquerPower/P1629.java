package BOJ.NumberTheory.DivideConquerPower;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow2(B, A, C));

    }
    public static long pow2(long index,long a, long c){
        if(index==1){
            return a % c;
        }
        else {
            long next = pow2(index / 2, a, c);
            if (index % 2 == 0) {
                return (next * next) % c;
            } else {
                return ((next * next)%c * a) % c;
            }
        }
    }
}
