package Study.SDS_day3.P2042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] nums, tree;
    static int N,M,K;
    static int S;

    public static void main(String[] args) throws  Exception{
        System.setIn(new FileInputStream("src/SDS.SDS_day3/P2042/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        nums = new long[N];

        for(int i=0; i< N;i++){
            nums[i] = Long.parseLong(bf.readLine());
        }

        S = 1;
        while(S<N){
            S *=2;
        }

        tree = new long[S*2];

        for(int i=0; i < N;i++){
            update(0,S-1,1,i,nums[i]);
        }

        for (int i = 1; i < S*2; i++) {
            System.out.println(tree[i]);
        }




    }

    static void initBU(){

        for (int i = 0; i < N; i++) {
            tree[S+i] = nums[i];
        }

        for (int i = S-1; i > 0; i--) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    static long query(int left, int right, int node, int queryLeft, int queryRight){
        if(queryLeft>left || right<queryRight){
            return 0;
        }
        else if(queryLeft <= left && right <= queryRight){
            return tree[node];
        }else{
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node*2, queryLeft, queryRight);
            long resultRight = query(mid+1, right, node*2+1, queryLeft,queryRight);
            return resultLeft + resultRight;
        }
    }

    static void update(int left, int right, int node, int target, long diff){
        if(target < left || target > right){
            System.out.println("Out");
            return;
        }else {
            System.out.println("Do");
            tree[node] += diff;
            if(left != right){
                int mid = (left+right)/2;
                update(left, mid, node*2, target, diff);
                update(mid+1, right, node*2+1, target, diff);
            }
        }
    }

    static long queryBU(int queryLeft, int queryRight){
        int left = S + queryLeft-1;
        int right = S + queryRight -1;

        long sum = 0;

        while(left<=right){
            if(left % 2==1){
                sum += tree[left++];
            }
            if(right % 2 == 0){
                sum += tree[right--];
            }

            left /= 2;
            right /= 2;
        }
        return sum;

    }

    static void updateBU(int target, long value){
        int node = S + target -1;
        tree[node] = value;
        node/=2;
        while(node>0){
           tree[node] = tree[node*2]+tree[node*2+1];
            node/=2;
        }
    }


}
