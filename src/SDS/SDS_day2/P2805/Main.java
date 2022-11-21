package SDS.SDS_day2.P2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long max=0;
    static long tree[];
    static long minLength, cutLength;

    public static void BS(long min, long max){
        if(min>max){
            return;
        }
        long mid = (min+max)/2;

        long length = getLength(mid);
        System.out.println(min+" "+mid+" "+max+" "+length);
        if(length<minLength && length>M){
            minLength = length;
            cutLength = mid;
        }
        if(length==M){
            minLength = length;
            cutLength = mid;
            return;
        }else if(length>M){
            BS(mid+1,max);
        }else if(length<M){
            BS(min,mid-1);
        }


    }

    public static long getLength(long length){
        long sum=0;
        for(int i=0;i<N;i++){
            sum+=Math.max(0,tree[i]-length);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("src/SDS.SDS_day2/P2805/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new long[N];

        minLength = Integer.MAX_VALUE;

        st = new StringTokenizer(bf.readLine()," ");
        for(int i=0;i<N;i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(tree[i],max);
        }

        BS(0,max);

        System.out.println(cutLength);

    }

}
