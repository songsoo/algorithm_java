package BOJ.Implement.Bronze.P28702;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ_Repository\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String one = bf.readLine();
        String two = bf.readLine();
        String three = bf.readLine();
        // 숫자가 하나라도 나오면 그걸 토대로
        // 첫번째가 3의 배수라면 4번째도 3의 배수
        // fizz buzz인지 확인
        if(one.equals("Fizz")){
            if(two.equals("Buzz")){
                System.out.println("Fizz");
            }
            // 첫번째가 3의 배수면 두번째는 5의 배수아니면 숫자
            else{
                if((Integer.parseInt(two)+2)%5==0){
                    System.out.println("FizzBuzz");
                }else{
                    System.out.println("Fizz");
                }
            }
        }
        // 첫번재가 5의 배수라면
        else if(one.equals("Buzz")){
            // 다음이 3의 배수라면 그 다음은 무조건 숫자
            if(two.equals("Fizz")){
                System.out.println(Integer.parseInt(three)+1);
            }
            // 다음이 숫자라면 그냥 더한다
            else{
                System.out.println(Integer.parseInt(two)+2);
            }
        }
        // 3과 5의 배수라면 무조건 3의 배수
        else if(one.equals("FizzBuzz")){
            System.out.println("Fizz");
        }
        //첫번째가 3의배수도 5의 배수도 아니라면
        else{
            if((Integer.parseInt(one)+3)%5==0){
                System.out.println("Buzz");
            }else{
                System.out.println(Integer.parseInt(one)+3);
            }
        }

    }
}
