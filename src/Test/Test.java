package Test;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {



    public static void main(String[] args) throws NumberFormatException, IOException {

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            a.add(tmp);
        }
        for (ArrayList<Integer> b : a){
            System.out.println(a.indexOf(b));
        }
        System.out.println(a.toString());
    }

}