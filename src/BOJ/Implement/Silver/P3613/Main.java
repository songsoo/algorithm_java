package BOJ.Implement.Silver.P3613;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isJava = false;
        boolean isC = false;
        boolean flag = true;
        for (int i = 0; i < str.length; i++) {
            // 대문자
            if(str[i]>='A' && str[i]<='Z'){
                sb.append("_"+(char)(str[i]+32));
                if(i==0 || isC){
                    flag = false;
                    break;
                }
                isJava = true;
            }else if(str[i]=='_'){
                if(isJava){
                    flag = false;
                    break;
                }
                if(i==0 || (++i)>=str.length || str[i]<'a' || str[i]>'z'){
                    flag = false;
                    break;
                }else{
                    sb.append((char)(str[i]-32));
                }
                isC = true;
            }else{
                sb.append(str[i]);
            }
        }
        System.out.println(flag?sb.toString():"Error!");
    }
}
