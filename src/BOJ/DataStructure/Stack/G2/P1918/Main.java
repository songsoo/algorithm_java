package BOJ.DataStructure.Stack.G2.P1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        // +,-이고 뒤가 *,/,(이거나  *,/ 뒤에 (가 나온다면 뒤의 것을 먼저 진행
        // +,-이고 뒤가 +,-이거나 *,/뒤에 (가 안나오거나 뒤가 )로 닫히면 바로 진행
        // 왼쪽은 먼저 스택에 넣음
    }


}
