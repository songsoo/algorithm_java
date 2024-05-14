package BOJ.BruteForce.BackTracking.Gold.P18428;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, maxDepth;
    static int[] moveX = {-1,0,1,0}, moveY={0,-1,0,1};
    static ArrayList<int[]> teachers, cand;
    static char[][] map;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("C:\\Users\\송수현\\IdeaProjects\\algorithm_java\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        ArrayList<int[]> students = new ArrayList<>();
        teachers = new ArrayList<>();
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                char cur = st.nextToken().charAt(0);
                map[i][j] = cur;
                if(cur=='S'){
                    students.add(new int[]{i,j});
                }else if(cur=='T'){
                    teachers.add(new int[]{i,j});
                }
            }
        }

        boolean[][] visited = new boolean[N][N];
        cand = new ArrayList<>();
        boolean flag = true;

        loop:
        for(int i=0; i<students.size(); i++){
            // 상하좌우 넣기
            // 상하좌우에 T가 있으면 종료
            int[] cur = students.get(i);
            for (int j = 0; j < 4; j++) {
                int nextX = cur[0] + moveX[j];
                int nextY = cur[1] + moveY[j];
                if(check(nextX, nextY)){
                    if(map[nextX][nextY]=='T'){
                        flag = false;
                        break loop;
                    }
                    if(!visited[nextX][nextY] && map[nextX][nextY]=='X'){
                        cand.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }

            for (int j = i+1; j < students.size(); j++) {
                //겹치는 위치 넣기
                int[] next = students.get(j);
                if(check(cur[0], next[1]) && !visited[cur[0]][next[1]] && map[cur[0]][next[1]]=='X'){
                    cand.add(new int[]{cur[0], next[1]});
                    visited[cur[0]][next[1]] = true;
                }
                if(check(next[0], cur[1]) && !visited[next[0]][cur[1]] && map[next[0]][cur[1]]=='X'){
                    cand.add(new int[]{next[0], cur[1]});
                    visited[next[0]][cur[1]] = true;
                }
            }
        }

        maxDepth = Math.min(3, cand.size());

        if(flag){
            if(selectCand(0,0)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }else{
            System.out.println("NO");
        }



    }
    public static boolean selectCand(int index, int depth){
        if(depth==maxDepth){
            return teacherCheck();
        }
        for (int i = index; i < cand.size(); i++) {
            int[] cur = cand.get(i);
            map[cur[0]][cur[1]] = 'O';
            if(selectCand(i+1, depth+1)){
                return true;
            }
            map[cur[0]][cur[1]] = 'X';
        }
        return false;
    }
    public static boolean check(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
    public static boolean teacherCheck(){
        for(int[] cur : teachers){
            for (int i = 0; i < 4; i++) {
                int x = cur[0]+moveX[i];
                int y = cur[1]+moveY[i];
                while(check(x,y) && map[x][y]!='T' && map[x][y] !='O'){
                    if(map[x][y]=='S'){
                        return false;
                    }
                    x += moveX[i];
                    y += moveY[i];
                }
            }
        }
        return true;
    }
}
