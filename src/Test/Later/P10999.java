package Test.Later;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10999 {
    static int N,M,K;
    static long arr[];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\ssafy\\intelliJWorkSpace\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N+1];

        for (int i = 1; i < N+1; i++) {
            addNum(i,Long.parseLong(bf.readLine()));
        }

        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx = Integer.parseInt(st.nextToken());
            if(idx==1){
                long start=Long.parseLong(st.nextToken());
                long end =Long.parseLong(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                setNum(start,end,value);
            }else if(idx==2){
                long start=Long.parseLong(st.nextToken());
                long end =Long.parseLong(st.nextToken());
                System.out.println(getNum(start,end));
            }
        }
    }

    public static void addNum(long i, long num){
        if(i%2==1){
            arr[(int)i] = num;
        }else{
            int sum = (int)num;
            int index = 0;
            while((i>>index & 1) == 0){
                sum += arr[(int)i-(1<<index)];
                index++;
            }
            arr[(int)i] = sum;
        }
    }

    public static void setNum(long i, long j, long num){
        for (int k = (int)i; k <= j; k++) {
            arr[k] += num;
            int cur = k;
            while(cur<=N){
                int index = 0;
                while((cur>>index & 1) == 0){
                    index++;
                }
                cur+= 1<<index;
                if(cur>N){
                    break;
                }
                arr[cur] += num;
            }
        }
    }

    public static int getNum(long i, long j){
        //j까지의 구간합 먼저 구하기
        int sumJ = 0;
        int index = 0;
        while(j>0){
            sumJ += arr[(int)j];
            while((j>>index & 1) == 0){
                index++;
            }
            j -= 1<<index;
        }
        i = i - 1;
        int sumI = 0;
        index = 0;
        while(i>0){
            sumI += arr[(int)i];
            while((i>>index & 1) == 0){
                index++;
            }
            i -= 1<<index;
        }
        return sumJ-sumI;
    }


}
