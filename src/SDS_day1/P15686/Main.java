package SDS_day1.P15686;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] street;
    static ArrayList<int[]> house, chicken;
    static boolean[] selected;
    static int chickenDistance;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS_day1/P15686N/input.txt"));
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        street = new int[N][];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        selected = new boolean[N*N];
        chickenDistance = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            street[i] = new int[N];
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                street[i][j] = Integer.parseInt(st.nextToken());
                if(street[i][j]==1){
                    int[] tmp = {i,j};
                    house.add(tmp);
                }else if(street[i][j]==2){
                    int[] tmp = {i,j};
                    chicken.add(tmp);
                }
            }
        }

        goNext(-1,0);
        System.out.println(chickenDistance);

    }

    public static void goNext(int prev, int depth){
        if(depth==M){
            int nowTotal = getDistance();
            if(chickenDistance > nowTotal){
                chickenDistance = nowTotal;
            }
        }else{
            for (int i = prev+1; i < chicken.size(); i++) {
                selected[i] = true;
                goNext(i,depth+1);
                selected[i] = false;
            }
        }
    }

    public static int getDistance(){
        int total = 0;
        for(int[] a : house){
            int dis = Integer.MAX_VALUE;
            for(int i = 0 ; i < chicken.size();i++){
                if(!selected[i]){
                    continue;
                }
                int[] b = chicken.get(i);
                int tmp = Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
                if(dis > tmp){
                    dis = tmp;
                }
            }
            total += dis;
        }
        return total;
    }
    // 백트래킹을 활용
    // 모든 가능한 치킨 집 방법을 순회한다
    // dfs(depth)
    // depth확인, 최저보다 낮으면 최저 바꾸기
    // 그 외엔 for문을 돌면서 체크
}
