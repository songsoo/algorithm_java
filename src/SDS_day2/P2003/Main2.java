package SDS_day2.P2003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main2 {

    static int N,M;
    static int[] array;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS_day2/P2003/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N+1];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // left, right key를 하나씩 둔다
        // right를 하나씩 오른쪽으로 넘어가는데, 기준치보다 작으면 계속 넘어가고 같거나 크면 오른쪽은 그대로 둔 상태로 왼쪽을 오른쪽으로 이동시킨다.
        // 같은 숫자가 나올 때마다 result를 증가시키고
        // 오른쪽이 끝까지 도달했을 때 작으면 종료, 크면 왼쪽을 하나씩 이동

        int left=0, right=0, sum=array[0],result=0;

        while(!(right==N-1 && sum <M) && right<N){

            if(sum<M){
                sum += array[++right];
            }else if(sum == M){
                sum-=array[left++];
                sum+=array[++right];
                result++;
            }else{
                sum-=array[left++];
            }
            if(left>right){
                sum+=array[++right];
            }
            System.out.println(left+" "+right+ " "+sum);
        }

        System.out.println(result);



    }

}
