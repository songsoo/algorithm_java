package BOJ.NumberTheory.PermaComb.G1.P11401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11401 {
    static int N, K, P;
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = 1000000007;
        System.out.println(nCk());
    }

    public static long getFact(int n){
        long prevFact = 1;
        long nextFact = 1;
        for (int i = 2; i <= n; i++) {
            nextFact = (i * prevFact) % P;
            prevFact = nextFact;

        }
        return nextFact;
    }

    public static long power(long n, long a) {
        long result = 1L;
        long cur = n;
        while (a > 0) {
            if ((a & 1) == 1) {
                result = (result * cur) %P;
            }
            cur = (cur * cur)%P;
            a = a >> 1;
        }
        return result;
    }

    public static long nCk(){
        return (getFact(N)*power(getFact(N-K),P-2)%P*power(getFact(K),P-2)%P)%P;
    }

}