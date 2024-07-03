package SWEA.D3.P15758;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static void main(String args[]) throws Exception
    {

        //System.setIn(new FileInputStream(""));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String str1 = "#"+sc.next();
            String subStr1=str1.substring(1);
            String str2 = "#"+sc.next();
            String subStr2=str2.substring(1);

            boolean found = true;

            for (int i = 1; i < str1.length() / 2 + 1; i++) {
                found = true;
                for (int j = 1 + i; j <= str1.length() - i; j+=i) {
                    //System.out.println(str1.substring(1, 1 + i)+" "+str1.substring(j, i + j));
                    if (!str1.substring(1, 1 + i).equals(str1.substring(j, i + j))) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    if((str1.length()-1)%i==0) {
                        subStr1 = str1.substring(1, i + 1);
                        break;
                    }
                }
            }



                for (int i = 1; i < str2.length() / 2 + 1; i++) {
                    found = true;
                    for (int j = 1 + i; j <= str2.length() - i; j+=i) {
                        if (!str2.substring(1, i + 1).equals(str2.substring(j, i + j))) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        if((str2.length()-1)%i==0) {
                            subStr2 = str2.substring(1, i + 1);
                            break;
                        }
                    }

            }
            //System.out.println(subStr1 + " "+ subStr2);
            if(subStr1.equals(subStr2)){
                System.out.println("#"+test_case+" yes");
            }else{
                System.out.println("#"+test_case+" no");
            }

        }
    }
}