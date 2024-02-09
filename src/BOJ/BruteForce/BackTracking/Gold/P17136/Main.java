package BOJ.BruteForce.BackTracking.Gold.P17136;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] isNotCovered;
    static int n =10, min=Integer.MAX_VALUE, count =0, notCoverNum=0, paperNum=0;
    static int[] papers={5,5,5,5,5};
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("E:\\SSAFY9\\intelliJ_workspace\\algorithm_java\\src\\BOJ\\BruteForce\\BackTracking\\G2\\P17136\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        isNotCovered = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                isNotCovered[i][j] = Integer.parseInt(st.nextToken());
                if(isNotCovered[i][j]==1){
                    notCoverNum++;
                }
            }
        }

        goNext(0,0,0);

        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }

    public static void goNext(int x, int y, int paperNum){

        if(count==notCoverNum){
            min = Math.min(min,paperNum);
            return;
        }

        int startX = x;
        int startY = y;
        if(startY>=n){
            startY -= 10;
            startX += 1;
        }
        loop:
        for (int i = startX; i < n; i++) {
            for (int j = startY; j < n; j++) {
                if(isNotCovered[i][j]==1){
                    startX = i;
                    startY = j;
                    break loop;
                }
            }
            startY=0;
        }
        // 현재 이후로 돌아오지 않음
        // 바로 다음에 만나는 (1인) x, y값 찾기, 없으면 return;
        // 해당 값에서 사각형 크기에 맞는 색종이 넣을 수 있는지 확인, 넣을 수 없으면 break;
        // 색종이 개수 확인, 없으면 continue;
        int i = startX;
        int j = startY;

                loop1:
                for (int k = 4; k >= 0; k--) {

                    if(i+k>=n || j+k>=n || papers[k]==0){
                        continue;
                    }
                    // k범위 이내에 0이 있는지 확인
                    for (int l = 0; l < k+1; l++) {
                        for (int m = 0; m < k+1; m++) {
                            if(isNotCovered[i+l][j+m]==0){
                                continue loop1;
                            }
                        }
                    }

                    for (int l = 0; l < k+1; l++) {
                        for (int m = 0; m < k + 1; m++) {
                            isNotCovered[i+l][j+m]=0;
                            count++;
                        }
                    }
                    papers[k]--;
                    goNext(x,y+1,paperNum+1);

                    for (int l = 0; l < k+1; l++) {
                        for (int m = 0; m < k + 1; m++) {
                            isNotCovered[i+l][j+m]=1;
                            count--;
                        }
                    }
                    papers[k]++;

                }

    }

    public static void printArr(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(isNotCovered[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
