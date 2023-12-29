package BOJ.SimpleSilver.P11729;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        move(N,1,3,2);
        System.out.println(count);
        System.out.println(sb.toString());

    }

    public static void move(int num, int from, int to, int another){
        if(num==1){
            count++;
            sb.append(from+" "+to+"\n");
            return;
        }
        // 먼저 상위의 것을 이동방향이 아닌 쪽으로 옮김
        move(num-1, from, another, to);
        // 현재의 것을 이동 방향으로 옮김
        count++;
        sb.append(from+" "+to+"\n");
        // 상위의 것을 원래 옮겨진 곳에서 원래 방향으로 옮김
        move(num-1, another, to, from);

    }
}
