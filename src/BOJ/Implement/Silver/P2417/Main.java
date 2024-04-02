package BOJ.Implement.Silver.P2417;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        if(n.compareTo(zero)==0){
            System.out.println(0);
        }else if(n.compareTo(one)==0){
            System.out.println(1);
        }else{
            System.out.println( n.compareTo(n.sqrt().multiply(n.sqrt()))==0 ? n.sqrt():n.sqrt().add(new BigInteger("1")) );
        }
    }
}
