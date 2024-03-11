package BOJ.TwoPointer.P22857;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());



        int arr[] = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int length = 0;
        int oddCnt = 0;
        int p = 0;
        int q = -1;
        //System.out.println("start");
        while(++q<N){
            //System.out.println(p+" "+(q-1)+" "+"go"+oddCnt);
            // 짝수일 때는 length 늘림
            if(arr[q]%2==0){
                length++;
                //System.out.println("cur length : "+ length);
                max = Math.max(max, length);
            }else{
                // 홀수일 땐 홀수 카운트 증가 후
                // 홀수 개수 많으면 이전 포인터 짝수나올 때 까지 옮기기
                if(++oddCnt > K){
                    while(p<q){
                        if(arr[p++]%2==1){
                            oddCnt--;
                            break;
                        }else{
                            length--;
                        }
                    }
                }
            }
        }
        System.out.println(max);

    }
}
