package Study.SDS_day2.P2842N;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int[][] area, altitude;
    static int startX, startY, difference, numOfHouse;
    static ArrayList<Integer> altitudeList;
    static int[] dx={0,0,-1,1,-1,-1,1,1}, dy={-1,1,0,0,-1,1,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day2/P2842/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());
        area = new int[T][];
        altitude = new int[T][];
        visited = new boolean[T][];
        numOfHouse = 0;
        difference = Integer.MAX_VALUE;
        altitudeList = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            String Line=st.nextToken();
            area[i] = new int[T];
            visited[i] = new boolean[T];
            for (int j = 0; j < T; j++) {
                if(Line.charAt(j)=='P'){
                    area[i][j] = 0;
                    startX = i;
                    startY = j;
                }else if(Line.charAt(j)=='K'){
                    area[i][j] = 1;
                    numOfHouse++;
                }else{
                    area[i][j] = 2;
                }

            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            altitude[i] = new int[T];
            for (int j = 0; j < T; j++) {
                altitude[i][j] = Integer.parseInt(st.nextToken());
                if(!altitudeList.contains(altitude[i][j])){
                    altitudeList.add(altitude[i][j]);
                }
            }
        }
        Collections.sort(altitudeList);

        //printMap();

        bs(0, 0);
        System.out.println(difference);
    }
    public static void bs(int min, int max){
        //System.out.println("min/max : "+min+" "+max);
        if(min>max || max>=altitudeList.size()-1){
            return;
        }

        visited=new boolean[T][];
        for (int i = 0; i < T; i++) {
            visited[i] = new boolean[T];
        }

        int mid = (min+max)/2;
        //System.out.println("min: "+altitudeList.get(min)+" max: "+altitudeList.get(max)+ altitudeList.get(mid));
        // DFS활용, visited, 하나라도 일단 발견하면 그 이후에 차이가 더 큰 것을 발견할 경우 배제한다.
        if(dfs(startX,startY,0,min,max)){
            //System.out.println(min+" "+mid+" "+max+" "+": 1");
            difference = Math.min(difference,altitudeList.get(max)-altitudeList.get(min));
            bs(min+1,max);
        }else{
            //System.out.println(min+" "+mid+" "+max+" "+": 2");
            bs(min,max+1);
        }

    }
    //이분 서치를 활용 최소~최대를
    public static boolean dfs(int x, int y, int index,int min, int max){
        //체크인
        visited[x][y]=true;
        //System.out.println(x+" "+y);
        //printVisit();
        if(area[x][y]==1){
            index++;
        }
        //모두 돌았는지 확인
        if(index==numOfHouse){
            return true;
        }
        //다음 좌표들 모두 넘어가기
        for (int i = 0; i < 8; i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(!(nextX<0 || nextX>=T || nextY<0 || nextY>=T || visited[nextX][nextY])){
                //System.out.println(altitude[nextX][nextY]+" "+altitudeList.get(max)+" "+altitudeList.get(min));
                if(altitude[nextX][nextY]<=altitudeList.get(max) && altitude[nextX][nextY]>=altitudeList.get(min)){
                    //System.out.println("go");
                    if(dfs(nextX,nextY,index,min,max)){
                        return true;
                    }
                }else{
                    //System.out.println("stop");

                }
            }
        }
        //체크아웃
        visited[x][y]= false;
        return false;
    }

    public static void printVisit(){
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                if(visited[i][j]){
                    System.out.print("O"+" ");
                }else{
                    System.out.print("X"+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMap(){
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
               System.out.print(altitude[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
