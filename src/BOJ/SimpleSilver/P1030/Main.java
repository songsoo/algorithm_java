package BOJ.SimpleSilver.P1030;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S,N,K,R1,R2,C1,C2;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //시간이 지남
        S = Integer.parseInt(st.nextToken());
        //초기 사이즈
        N = Integer.parseInt(st.nextToken());
        //초기 검정색 크기
        K = Integer.parseInt(st.nextToken());
        //출력 사이즈
        R1 = Integer.parseInt(st.nextToken());
        R2 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());

        //s에 따라 N의 거듭제곱만큼 커짐
        StringBuilder sb = new StringBuilder();
        for (int i = R1; i < R2+1; i++) {
            for (int j = C1; j < C2+1; j++) {
                sb.append(isIn(i,j,S)?1:0);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    //index 몇번째 넘어왔는지 (시작:S)
    public static boolean isIn(long r, long c, long index){
        if(index==0){
            return false;
        }
        long curBoxSize = (int)Math.pow(N,index);
        long curInnerSize = curBoxSize*K/N;
        if(isIn2(r%curBoxSize,curBoxSize,curInnerSize) && isIn2(c%curBoxSize,curBoxSize,curInnerSize)){
            return true;
        }
        return isIn(r%curInnerSize,c%curInnerSize,index-1);
    }

    public static boolean isIn2(long i, long N, long K){
        return (N-K)/2<=i && N-((N-K)/2)>i;
    }
}
