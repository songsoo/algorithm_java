package Study.SDS_day3.P2042;

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    static int N,M,K,s;
    static long[] tree, num;
    static long tmp;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SDS.SDS_day3/P2042/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new long[N+1];
        s=1;
        while(s<N){
           s*=2;
        }

        tree = new long[2*s+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            tmp = Long.parseLong(st.nextToken());
            num[i] = tmp;
            tree[s+i-1] = tmp;
        }

        // 트리 만들기
        makeTree(1);
        //printTree();

        // 1과 2에 따라서 행동 개시
        int op;
        long num1, num2;
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(bf.readLine());
            op = Integer.parseInt(st.nextToken());
            num1 = Long.parseLong(st.nextToken());
            num2 = Long.parseLong(st.nextToken());
            if(op==1){
                int cur = s + (int)num1 - 1;
                long diff = num2 -tree[cur] ;
                changeValue(cur, diff);
                //PrintTree();
            }
            if(op==2){
                System.out.println(printValue((int)num1,(int)num2,1,s,1));
            }
        }
        //printTree();

    }

    public static long makeTree(int i){
        if(i>=s && i<2*s){
            return tree[i];
        }else if(i>=2*s){
            return 0;
        }
        tree[i] =  makeTree(2*i) + makeTree(2*i+1);
        return tree[i];
    }

    public static void printTree(){
        int i=1;
        int count = 1;
        while(i<=2*s){
            System.out.print(tree[i]+" ");
            if(i == count){
                System.out.println();
                count = i*2+1;
            }
            i++;
            if(i == 2*s){
                break;
            }
        }
    }

    public static void changeValue(int cur, long diff){
        if(cur==0){
            return;
        }
        tree[cur] += diff;
        changeValue(cur/2, diff);
    }

    public static long printValue(int x, int y, int curLeft, int curRight, int curIndex){

        if(curLeft>=x && curRight<=y){
            return tree[curIndex];
        }
        long sum = 0;
        // mid는 curLeft와 curRight의 중간
        int mid = (curLeft+curRight)/2;
        // mid보다 x가 작거나 같으면 왼쪽 함 (y/2)
        if(mid>=x){
            sum+=printValue(x,y,curLeft,mid,curIndex*2);
        }
        if(mid<y){
            sum+=printValue(x,y,mid+1,curRight,curIndex*2+1);
        }
        // mid+1보다 y가 크거나 같으면 오른쪽 함 (x = y/2+1)

        return sum;
    }

}
