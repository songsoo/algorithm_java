package SDS.SDS_day3.P4358;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static HashMap<String, Integer> trees;
    static ArrayList<String> keySet;

    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/SDS.SDS_day3/P4358/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name = bf.readLine();
        int num=0;
        trees = new HashMap<String, Integer>();

        while(!(name==null)){
            if(!trees.containsKey(name)){
                trees.put(name,1);
            }else{
                trees.put(name,trees.get(name)+1);
            }
            name = bf.readLine();
            num++;
        }

        keySet = new ArrayList<>(trees.keySet());
        Collections.sort(keySet);

        for (int i = 0; i < keySet.size(); i++) {
            int freq = trees.get(keySet.get(i));
            System.out.println(keySet.get(i)+String.format(" %.4f",((float)freq/(float)num)*100));
        }
    }

}
