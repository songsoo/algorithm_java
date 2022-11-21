package SDS.SDS_day6.P11438;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{

    static int N,M,depthMax,k;
    static int parent[][];
    static int oneParent[];
    static int depth[];
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day6/P11438/Input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        depth = new int[N+1];
        oneParent = new int[N+1];
        depth[1] = 0;
        depthMax = 0;

        for (int i = 0; i < N-1; i++) {

            st = new StringTokenizer(bf.readLine()," ");

            int up = Integer.parseInt(st.nextToken());
            int down = Integer.parseInt(st.nextToken());

            if(oneParent[up]<oneParent[down]){
                int tmp = up;
                up = down;
                down = tmp;
            }

            depth[down] = depth[up]+1;
            oneParent[down] = up;


            if(depth[down]>depthMax){
                depthMax = depth[down];
            }
        }

        k = (int) (Math.log10(depthMax)/ Math.log10(2))+1;

        parent = new int[k][N+1];

        parent[0] = oneParent;

        for(int i=1;i<k;i++){
            for(int j=0;j<N+1;j++){
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }


        M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c;
            int diff = (depth[a]-depth[b]);
            LinkedList<Integer> binary = new LinkedList<>();

            if(diff != 0){
                //a가 크다고 간주
                if(diff<0){
                    c = a;
                    a = b;
                    b = c;
                }
                while(diff!=0){
                    int no = diff%2;
                    diff/=2;
                    binary.add(no);
                }
                while(!binary.isEmpty()){
                    int no = binary.remove(binary.size()-1);
                    if(no!=0) {
                        a = parent[binary.size()][a];
                    }
                }
            }

            System.out.println(getLCS(a,b));
        }




    }
    public static int getLCS(int a, int b){
        if(a==b){
            return a;
        }
        if(oneParent[a]==oneParent[b]){
            return oneParent[a];
        }
        int i, result=1;
        for(i=0;i<k;i++){
            if(parent[i][a]==parent[i][b]){
                result = getLCS(parent[i-1][a],parent[i-1][b]);
            }
        }
        return result;
    }



}
