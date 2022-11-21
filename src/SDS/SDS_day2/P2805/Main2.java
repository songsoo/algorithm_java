package SDS.SDS_day2.P2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int N,M;
    static long shortestCutLength,result;
    static long[] tree;



    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day2/P2805/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new long[N];
        shortestCutLength = Long.MAX_VALUE;
        st = new StringTokenizer(bf.readLine());

        long longestTree = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            if(tree[i]>longestTree){
                longestTree = tree[i];
            }
        }
        BS(0,longestTree);
        System.out.println(result);



    }

    public static void BS(long low, long high){
        //high-low/2한 길이 구하고
        // 짧으면 위쪽 길면 아래쪽
        if(low>high){
            return;
        }
        System.out.print(low + " "+ high);
        long mid = (high+low)/2;
        long sum = 0;
        long diff;
        for (int i = 0; i < N; i++) {
            diff = tree[i] - mid;
            if(diff>0){
                sum+=diff;
            }
        }
        System.out.println(" "+sum);
        if(sum<M){
            BS(low,mid-1);
        }else if(sum==M){
            result = mid;
        }else{
            if(shortestCutLength>(sum-M)){
                shortestCutLength =sum-M;
                System.out.println(sum-M+"there");
                result = mid;
            }
            BS(mid+1,high);
        }
    }
}
//shortestCutLenght 갱신 안함
//sum<M일때 갱신하면 안되는데 했음
//binary search 종료 조건 충족 못함, (low,mid-1)로 변경하여 해결