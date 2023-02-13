package BOJ.DivideConquer.S1.P1074;

import java.util.Scanner;

public class Main {
    static long N, r, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        goNext(0,0,1<<(N-1),0);
    }
    public static void goNext(int x, int y, int index, long count){
        //매번 돌면서 index에 따라 몇사분면에 위치해있는지 확인하고
        //이에 따라 방문 횟수를 추가한다.
        if(x==r && y==c){
            System.out.print(count);
            return;
        }

        if(r<x+index){
            //왼쪽 위
            if(c<y+index){
                goNext(x,y,index/2,count);
            }
            //오른쪽 위
            else{
                if(index!=1){
                    goNext(x,y+index,index/2,count+((int)Math.pow(index,2)));
                }else {
                    goNext(x, y + index, index / 2, count + 1);
                }
            }
        }
        else{
            //왼쪽 아래
            if(c<y+index){
                if(index!=1) {
                    goNext(x + index, y, index / 2, count + (int)Math.pow(index,2)*2);
                }else{
                    goNext(x + index, y, index / 2, count + 2);

                }
            }
            //오른 아래
            else{
                if(index!=1) {
                    goNext(x + index, y + index, index / 2, count + (int)Math.pow(index,2)*3);
                }else{
                    goNext(x + index, y + index, index / 2, count + 3);

                }
            }
        }
    }
}
