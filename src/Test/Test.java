package Test;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {



    public static void main(String[] args) throws NumberFormatException, IOException {

        int a = 13;

        for(int i=0;i<5;i++){
            System.out.println(a&1<<i);
        }

    }

}