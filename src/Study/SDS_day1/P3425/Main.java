package Study.SDS_day1.P3425;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<Long> numStack;
    static ArrayList<Long> numList;
    static boolean finish;
    static Long num;
    static int idx=0;
    static Long limit = Long.valueOf(1000000000);
    static ArrayList<String> inputList;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day1/P3425/execute.in"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        finish = false;
        String input="";
        while(true){

            numList = new ArrayList<>();
            inputList = new ArrayList<>();

            // 연산자 입력 부분
            while(true){
                input = bf.readLine();
                //System.out.println(input);
                if(input.equals("END")){
                    break;
                }else if(input.equals("QUIT")){
                    finish = true;
                    break;
                }else{
                    inputList.add(input);
                }
            }

            if(finish){
                break;
            }

            st = new StringTokenizer(bf.readLine());
            num = Long.parseLong(st.nextToken());

            // 숫자 입력 부분
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(bf.readLine());
                long inputLong = Long.parseLong(st.nextToken());
                numList.add(inputLong);
            }

            // 계산 부분
            //System.out.println(idx++);

            for (int i = 0; i < numList.size(); i++) {

                numStack = new Stack<>();
                num = numList.get(i);
                long num2;
                numStack.add(num);

                for (int j = 0; j < inputList.size(); j++) {
                    String sss = inputList.get(j).substring(0,3);
                    finish = false;
                    switch(sss){
                        // 1개도 없을 때
                        case "NUM":
                            long newLong = Long.parseLong(inputList.get(j).substring(4));
                            if(newLong<0 || newLong>limit){
                                finish = true;
                            }else {
                                numStack.push(newLong);
                            }
                            break;
                        case "POP":
                            if(numStack.size()==0){
                                finish = true;
                            }else {
                                num = numStack.pop();
                            }
                            break;
                        case "INV":
                            if(numStack.size()==0){
                                finish = true;
                            }else {
                                num = numStack.pop();
                                numStack.push(-num);
                            }
                            break;
                        case "DUP":
                            if(numStack.size()==0){
                                finish = true;
                            }else {
                                num = numStack.pop();
                                numStack.push(num);
                                numStack.push(num);
                            }
                            break;
                        case "SWP":
                            if(numStack.size()<2){
                                finish = true;
                            }else {
                                num2 = numStack.pop();
                                num = numStack.pop();
                                numStack.push(num2);
                                numStack.push(num);
                            }
                            break;
                        case "ADD":
                            if(numStack.size()<2){
                                finish = true;
                            }else {
                                num2 = numStack.pop();
                                num = numStack.pop();
                                if(Math.abs(num+num2)>limit){
                                    finish =true;
                                }else {
                                    numStack.push(num + num2);
                                }
                            }
                            break;
                        case "SUB":
                            if(numStack.size()<2){
                                finish = true;
                            }else {
                                num2 = numStack.pop();
                                num = numStack.pop();
                                if(Math.abs(num-num2)>limit){
                                    finish =true;
                                }else {
                                    numStack.push(num - num2);
                                }
                            }
                            break;
                        case "MUL":
                            if(numStack.size()<2){
                                finish = true;
                            }else {
                                num2 = numStack.pop();
                                num = numStack.pop();
                                if(Math.abs(num*num2)>limit){
                                    finish =true;
                                }else {
                                    numStack.push(num * num2);
                                }
                            }
                            break;
                        case "DIV":
                            if(numStack.size()<2){
                                finish = true;
                            }else {
                                num2 = numStack.pop();
                                num = numStack.pop();
                                if (num2 == 0) {
                                    finish = true;
                                    break;
                                }
                                if(num == 0){
                                    numStack.push(Long.valueOf(0));
                                }else {
                                    numStack.push((Math.abs(num) / Math.abs(num2)) * (num / Math.abs(num)) * (num2 / Math.abs(num2)));
                                }
                            }
                            break;
                        case "MOD":
                            if(numStack.size()<2){
                                finish = true;
                            }else {
                                num2 = numStack.pop();
                                if (num2 == 0) {
                                    finish = true;
                                    break;
                                }
                                num = numStack.pop();
                                long tt = 1;
                                if(num != 0) {
                                    if ((num / Math.abs(num)) == -1 ) {
                                        tt = -1;
                                    }
                                    numStack.push((Math.abs(num) % Math.abs(num2))*tt);
                                }else{
                                    numStack.push(Long.valueOf(0));
                                }

                            }
                            break;
                    }
                    if(finish) {
                        break;
                    }

                }


                // stack에 1개 인지?
                if(numStack.size()==1 && !finish){
                    System.out.println(numStack.pop());
                }else{
                    System.out.println("ERROR");
                }

                finish = false;

            }
            System.out.println();
            bf.readLine();
        }


    }

}
