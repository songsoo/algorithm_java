package SWEA.D4.P4012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Next Permutation을 활용하여 다시 풀어본다.
public class Solution2 {
    static int T,N,min;
    static int countingStar=0;
    static int[][] arr;
    static int[] nextP;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algorithm_java\\src\\SWEA\\D4\\P4012\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(bf.readLine());
            min = Integer.MAX_VALUE;
            arr = new int[N][N];
            nextP = new int[N];
            for (int j = 0; j < N/2; j++) {
                nextP[nextP.length-1-j] = 1;
            }
            for (int k = 0; k < N; k++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            divideIngred();
            sb.append("#"+(i+1)+" "+min+"\n");
        }
        System.out.println(sb.toString());

    }
    static void divideIngred(){
        //식재료 구하는 방법을 조합으로 나누고
        //조합에 맞게 각각 식재료들에 따라 시너지를 구하고
        //시너지끼리 비교하고 최소값을 찾아낸다.
        do{
            System.out.println(Arrays.toString(nextP));
            getTaste();
        }while(np(nextP.length-1));
    }

    static void getTaste(){
        System.out.println(countingStar++);
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(nextP[i]==1&&nextP[j]==1){
                    sum1+=(arr[i][j]+arr[j][i]);
                }else if((nextP[i]==0)&&(nextP[j]==0)){
                    sum2+=(arr[i][j]+arr[j][i]);
                }
            }
        }
        min = Math.min(min,Math.abs(sum1-sum2));
    }

    static boolean np(int size) {
        int i = size;
        // 역순이 제대로 되어있지 않은 지점을 찾는다.
        while(i>0 && nextP[i-1]>=nextP[i]) {
            i--;
        }
        if(i==0) {
            //5 4 3 2 1
            //마지막부터 계속 올라가기만 하면 이미 역순으로 정렬된거임
            return false;
        }
        int j = size; // 다시 맨 오른쪽으로 가봐

        // 꼭대기에서 꺾인점과 비교해서
        // 오른쪽에서 가장 먼저 나오는 같거나 큰 숫자
        // i 이전 점은 모두 역순으로 정렬되어있는 상태이기 때문에
        // 가장 먼저 만나는 자신보다 큰 게
        // 자신보다 큰 숫자 중 가장 작은 숫자이다.
        while(nextP[i-1]>=nextP[j])j--;
        //swap
        int temp = nextP[i-1];
        nextP[i-1] = nextP[j];
        nextP[j] = temp;

        int k = size;
        // 뒷 숫자는 여전히 모두 역순으로 정렬되어있는거니까
        // (서로가 바로 앞/뒤 숫자이기 때문에 나머지 애들은 바뀌어도 정렬에 영향은 없다.)
        // 뒷 숫자를 최대한 작은 것으로 돌린다. 5 4 3 2 1
        // (맨 앞과 맨뒤를 서로 바꾸면서 가운데로 모임)
        while(i<k) {
            temp = nextP[i];
            nextP[i] = nextP[k];
            nextP[k] = temp;
            i++;
            k--;
        }

        return true;
    }
}
