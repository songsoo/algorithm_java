package SDS_day2.P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {
    static long T, result;
    static int arrayNum1,arrayNum2;
    static long[][] array1,array2;
    static ArrayList<Long> arrayList1, arrayList2;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SDS_day2/P2143/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        result = 0;

        st = new StringTokenizer(bf.readLine());
        arrayNum1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        array1 = new long[arrayNum1][];
        arrayList1 = new ArrayList<>();
        for (int i = 0; i < arrayNum1; i++) {
            array1[i] = new long[arrayNum1];
            array1[i][i] = Integer.parseInt(st.nextToken());
            arrayList1.add(array1[i][i]);
        }

        for (int i = 0; i < arrayNum1; i++) {
            for (int j = 0; j < arrayNum1-i-1; j++) {
                array1[j][i+j+1] = array1[j+1][i+j+1] + array1[j][i+j] -array1[j+1][i+j];
                arrayList1.add(array1[j][i+j+1]);
            }
        }

        st = new StringTokenizer(bf.readLine());
        arrayNum2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        array2 = new long[arrayNum2][];
        arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayNum2; i++) {
            array2[i] = new long[arrayNum2];
            array2[i][i] = Integer.parseInt(st.nextToken());
            arrayList2.add(array2[i][i]);
        }

        for (int i = 0; i < arrayNum2; i++) {
            for (int j = 0; j < arrayNum2-i-1; j++) {
                array2[j][i+j+1] = array2[j+1][i+j+1] + array2[j][i+j]-array2[j+1][i+j];
                arrayList2.add(array2[j][i+j+1]);
            }
        }

        Collections.sort(arrayList1);
        Collections.sort(arrayList2);

        /*
        for (int i = 0; i < arrayNum1; i++) {
            for (int j = 0; j < arrayNum1; j++) {
                System.out.print(array1[i][j]+" ");
            }
            System.out.println();

        }
        */
        //System.out.println(arrayList1.toString());
        //System.out.println(arrayList2.toString());


        // arrayList1를 for문으로 돌려서 이분탐색하여 찾아냄
        for (int i = 0; i < arrayList1.size(); i++) {
            result+= BS(0,arrayList2.size()-1,T-arrayList1.get(i));
        }

        System.out.println(result);

    }

    public static long BS(int left, int right, long value){
        if(left>right){
            return 0;
        }

        int mid = (left+right)/2;
        if(arrayList2.get(mid)>value){
            return BS(left,mid-1,value);
        }else if(arrayList2.get(mid)<value){
            return BS(mid+1,right,value);
        }else{
            return BS(left,mid-1,value) + BS(mid+1,right,value) + 1;
        }

    }

}
