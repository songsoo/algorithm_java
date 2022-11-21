package SDS.SDS_day2.P2003;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N,M,low,high,result,caseType,count;
    static int arr[];

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/SDS.SDS_day2/P2003/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        result = 0;

        st = new StringTokenizer(bf.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low =0, high=0, sum = arr[0], count=0;

        while(true) {

            if (sum == M) {
                sum -= arr[low++];
                count++;
            } else if (sum > M) {
                sum -= arr[low++];
            } else if (sum < M) {
                sum += arr[++high];
            }

            if(high==N){
                break;
            }


        }
        System.out.println(count);



    }


}
