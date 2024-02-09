package BOJ.BruteForce.BackTracking.Gold.P6987;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// P6987
public class Main {
    static final int country = 6;
    static final int match = 5;
    static int[][] matchRes;
    static int[][] matchCur;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 0; test_case < 4; test_case++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            boolean flag = true;
            matchRes = new int[country][3];
            for (int j = 0; j < country; j++) {
                int win = Integer.parseInt(st.nextToken());
                int draw = Integer.parseInt(st.nextToken());
                int lose = Integer.parseInt(st.nextToken());
                matchRes[j][0] = win;
                matchRes[j][1] = draw;
                matchRes[j][2] = lose;
                if(win + draw + lose != 5){
                    flag = false;
                    break;
                }
            }

            matchCur = new int[country][3];
            if(flag){
                System.out.print((goNext(0,1)?"1":"0")+" ");
            }else{
                System.out.print("0 ");
            }


        }
    }
    public static void print(){
        System.out.println("-------------------------");
        for (int i = 0; i < country; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matchCur[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
    public static boolean goNext(int curCountry, int index){
        // print();
        // 모든 국가 매치 종료
        if(curCountry==country){
            return true;
        }
        //현재 국가 매치 종료
        if(index==country){
            return goNext(curCountry+1, curCountry+2);
        }

        if(matchCur[curCountry][0]<matchRes[curCountry][0] && matchCur[index][2]<matchRes[index][2]){
            matchCur[curCountry][0]++;
            matchCur[index][2]++;
            if(goNext(curCountry, index+1)){
                return true;
            }
            matchCur[curCountry][0]--;
            matchCur[index][2]--;
        }

        if(matchCur[curCountry][1]<matchRes[curCountry][1] && matchCur[index][1]<matchRes[index][1]){
            matchCur[curCountry][1]++;
            matchCur[index][1]++;
            if(goNext(curCountry, index+1)){
                return true;
            }
            matchCur[curCountry][1]--;
            matchCur[index][1]--;
        }

        if(matchCur[curCountry][2]<matchRes[curCountry][2] && matchCur[index][0]<matchRes[index][0]){
            matchCur[curCountry][2]++;
            matchCur[index][0]++;
            if(goNext(curCountry, index+1)){
                return true;
            }
            matchCur[curCountry][2]--;
            matchCur[index][0]--;
        }
        return false;
    }

}
