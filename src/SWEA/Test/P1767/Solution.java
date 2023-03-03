package SWEA.Test.P1767;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 한쪽으로 갔을 때 막혀있다면 굳이 완성안된거 계속 보내지말고 그냥 다 돌리고 났을 떄 안바꾼거로 하나 더 보내라
public class Solution {
    static int T,N,resultMAX,lengthMin;
    static int[][] map;
    static int[] moveX = {0,-1,0,1}, moveY = {-1,0,1,0};
    static ArrayList<int[]> gos;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\SWEA\\Test\\P1767\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T ; test_case++) {
            N = Integer.parseInt(bf.readLine());
            map = new int[N][N];
            gos = new ArrayList<>();
            resultMAX = 0;
            lengthMin = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    //겉에꺼 모두 완료
                    if((i==0 || i== N-1 || j==0 || j==N-1) && map[i][j]==1){
                        map[i][j] = 2;
                        resultMAX++;
                    }
                    if(map[i][j]==1){
                        gos.add(new int[]{i,j});
                    }
                }
            }
            int tmp = resultMAX;
            int[][] mapCopy = arrayCopy(map);
            goNext(0, tmp, 0,mapCopy);
            System.out.println("#"+test_case+" "+lengthMin);
        }

    }
    public static int[][] arrayCopy(int[][] map){
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            newMap[i] = Arrays.copyOf(map[i],N);
        }
        return newMap;
    }

    public static void goNext(int index, int result, int length, int[][] mapCopy){
        // 다 성공해도 최대로 성공한 것보다 적으면 포기
        if(gos.size()-index+result < resultMAX){
            return;
        }
        if(index==gos.size()){
            if(result > resultMAX){
                resultMAX = result;
                lengthMin = length;
                return;
            }else if(result == resultMAX){
                lengthMin = Math.min(lengthMin, length);
                return;
            }
        }
        for (int i = 0; i < 4; i++) {
            int[][] newMap = arrayCopy(mapCopy);
            int res = goCheck(new int[]{gos.get(index)[0],gos.get(index)[1]},moveX[i],moveY[i], newMap );
            if(res==0){
                goNext(index+1,result + 0, length, mapCopy);
            }else {
                goNext(index+1, result + 1, length+res, newMap);
            }
        }

    }
    public static int goCheck(int[] loc, int moveX, int moveY,int[][] mapCopy){
        mapCopy[loc[0]][loc[1]] = 2;
        int count = 0;
        int nextX = loc[0] + moveX;
        int nextY = loc[1] + moveY;
        while(nextX>=0 && nextX<N && nextY>=0 && nextY<N){
            if(mapCopy[nextX][nextY]==1 || mapCopy[nextX][nextY]==2){
                return 0;
            }
            mapCopy[nextX][nextY] = 2;
            count++;
            nextX = nextX + moveX;
            nextY = nextY + moveY;
        }
        return count;
    }
}
