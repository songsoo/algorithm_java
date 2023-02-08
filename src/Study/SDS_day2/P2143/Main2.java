package Study.SDS_day2.P2143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {
    static long T, result;
    static int arrayNum1,arrayNum2;
    static long[] array1,array2;
    static ArrayList<Long> arrayList1, arrayList2;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/SDS.SDS_day2/P2143/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        result = 0;

        st = new StringTokenizer(bf.readLine());
        arrayNum1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        array1 = new long[arrayNum1];
        arrayList1 = new ArrayList<>();
        for (int i = 0; i < arrayNum1; i++) {
            array1[i] = Integer.parseInt(st.nextToken());
            arrayList1.add(array1[i]);
        }

        for (int i = 0; i < array1.length; i++) {
            int sum=0;
            for(int j = i+1 ; j < array1.length; j++){
                sum+=array1[j];
                arrayList1.add(array1[i]+sum);
            }
        }



        st = new StringTokenizer(bf.readLine());
        arrayNum2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        array2 = new long[arrayNum2];
        arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayNum2; i++) {
            array2[i] = Integer.parseInt(st.nextToken());
            arrayList2.add(array2[i]);
        }

        for (int i = 0; i < array2.length; i++) {
            int sum=0;
            for(int j = i+1 ; j < array2.length; j++){
                sum+=array2[j];
                arrayList2.add(array2[i]+sum);
            }
        }


        Collections.sort(arrayList1);
        Collections.sort(arrayList2,Collections.reverseOrder());
        int pta=0, ptb=0;
        while(true){
            long curA = arrayList1.get(pta);
            long curB = arrayList2.get(ptb);

            if(curA + curB == T){
                long countA = 0;
                long countB = 0;
                int index=pta;

                while(index<arrayList1.size() && arrayList1.get(index++)==curA){
                    countA++;
                }
                index = ptb;
                while(index<arrayList2.size() && arrayList2.get(index++)==curB){
                    countB++;
                }
                result += countA*countB;
                pta+=countA;
                ptb+=countB;

            }else if(curA + curB > T){
                ptb++;
            }else{
                pta++;
            }

            if(pta == arrayList1.size() || ptb == arrayList2.size()){
                break;
            }

        }

        System.out.println(result);

    }


}
