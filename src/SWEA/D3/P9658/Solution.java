package SWEA.D3.P9658;

import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str = sc.next();
            int count = str.length();
            //앞 세글자 따서 세번쨰에서 반올림
            int cur = Integer.parseInt(str.substring(0,3));
            float tmp = (float)cur/(float)100.0;
            tmp = Math.round(tmp*10)/(float)10.0;
            //tmp가 10보다 커지는 경우
            if(tmp==10){
                tmp/=(float)10.0;
                count++;
            }
            System.out.println("#"+test_case+" "+tmp + "*10^" + --count);

        }
    }
}