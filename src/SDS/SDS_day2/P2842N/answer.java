package SDS.SDS_day2.P2842N;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class answer {

    static int T, startX, startY, numOfHouse;
    static Integer[] altitudeList;
    static int[][] altitude, area;
    static boolean[][] visited;
    static int difference;
    static int[] dx={0,0,-1,1,1,1,-1,-1}, dy={1,-1,0,0,-1,1,-1,1};
    static Queue<int[]> queue;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day2/P2842N/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());
        numOfHouse = 0;
        difference = Integer.MAX_VALUE;
        area = new int[T][];
        visited = new boolean[T][];
        altitude = new int[T][];

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
                }else if(Line.charAt(j)=='.'){
                    area[i][j] = 2;
                }

            }
        }

        Set<Integer> altitudeSet = new HashSet<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            altitude[i] = new int[T];
            for (int j = 0; j < T; j++) {
                altitude[i][j] = Integer.parseInt(st.nextToken());
                altitudeSet.add(altitude[i][j]);
            }
        }
        altitudeList = new Integer[altitudeSet.size()];
        altitudeList = altitudeSet.toArray(new Integer[0]);

        Arrays.sort(altitudeList);

        twoPointer(0,0);

        System.out.println(difference);

    }

    public static void twoPointer(int min, int max){
        visited = new boolean[T][];
        for (int i = 0; i < T; i++) {
            visited[i] = new boolean[T];
        }
        if(max>=altitudeList.length || min >= altitudeList.length){
            return;
        }
        //System.out.println(altitudeList[min]+" "+altitudeList[max]+"---------");

        queue = new LinkedList<>();
        if (altitude[startX][startY]<=altitudeList[max] && altitude[startX][startY]>=altitudeList[min]) {
            int[] start = {startX, startY};
            //visited[startX][startY] = true;
            queue.offer(start);
        }

        if(BFS(altitudeList[min],altitudeList[max])){
            difference = Math.min(altitudeList[max]-altitudeList[min], difference);
            twoPointer(min+1,max);
        }else{
            twoPointer(min,max+1);
        }

    }

    public static boolean BFS(int min, int max){

        int curK = 0;
        // while queue에 값이 있다면
        while(!queue.isEmpty()){
            // 목적지인가? 1. 해당 지점이 K인가 2. K의 개수 확인
            int[] curLoc = queue.poll();
            if(visited[curLoc[0]][curLoc[1]]) {
                continue;
            }
            visited[curLoc[0]][curLoc[1]]=true;

            if(area[curLoc[0]][curLoc[1]]==1){
                curK++;
            }
            //System.out.print(curLoc[0]+" "+curLoc[1]);
            if(curK == numOfHouse){
                //System.out.println("Found it!!");
                return true;
            }
            //System.out.println(" "+curK+" "+numOfHouse);

            for (int i = 0; i < 8; i++) {
                int nextX = curLoc[0] + dx[i];
                int nextY = curLoc[1] + dy[i];
                //visited 확인, 음수인지, T이상인지 확인
                if(!(nextX < 0) && !(nextY < 0) && !(nextX >= T) && !(nextY >= T)) {
                    if (altitude[nextX][nextY] <= max && altitude[nextX][nextY] >= min) {
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            // 방문한 적이 없다면 다음으로 갈 수 있는 곳 queue에 추가 (연결되어있으면서 min~max 사이에 있는 지점)
        }
        return false;
    }


}
