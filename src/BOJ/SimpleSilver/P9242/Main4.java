package BOJ.SimpleSilver.P9242;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
    static char[][] word;
    static char[][][] number =
            {
                    //0
                    {{'*','*','*'},{'*',' ','*'},{'*',' ','*'},{'*',' ','*'},{'*','*','*'}},
                    //1
                    {{' ',' ','*'},{' ',' ','*'},{' ',' ','*'},{' ',' ','*'},{' ',' ','*'}},
                    //2
                    {{'*','*','*'},{' ',' ','*'},{'*','*','*'},{'*',' ',' '},{'*','*','*'}},
                    //3
                    {{'*','*','*'},{' ',' ','*'},{'*','*','*'},{' ',' ','*'},{'*','*','*'}},
                    //4
                    {{'*',' ','*'},{'*',' ','*'},{'*','*','*'},{' ',' ','*'},{' ',' ','*'}},
                    //5
                    {{'*','*','*'},{'*',' ',' '},{'*','*','*'},{' ',' ','*'},{'*','*','*'}},
                    //6
                    {{'*','*','*'},{'*',' ',' '},{'*','*','*'},{'*',' ','*'},{'*','*','*'}},
                    //7
                    {{'*','*','*'},{' ',' ','*'},{' ',' ','*'},{' ',' ','*'},{' ',' ','*'}},
                    //8
                    {{'*','*','*'},{'*',' ','*'},{'*','*','*'},{'*',' ','*'},{'*','*','*'}},
                    //9
                    {{'*','*','*'},{'*',' ','*'},{'*','*','*'},{' ',' ','*'},{'*','*','*'}},
            };

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        word = new char[5][4*8];
        for (int i = 0; i < 5; i++) {
            word[i] = bf.readLine().toCharArray();
        }
        boolean flag = true;
        int num = 0;
        int index = 0;
        while(index+2 < word[0].length){
            int cur = getNum(index);
            if(cur==-1){
                flag = false;
                break;
            }else{
                num *= 10;
                num += cur;
            }
            index+=4;
        }
        if(flag){
            System.out.println(num%6==0?"BEER!!":"BOOM!!");
        }else{
            System.out.println("BOOM!!");
        }
    }

    public static int getNum(int index){
        loop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 3; k++) {
                    if(word[j][index+k]!=number[i][j][k]){
                        continue loop;
                    }
                }
            }
            return i;
        }
        return -1;
    }
}
