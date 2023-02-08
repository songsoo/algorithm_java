package Study.SDS_day2.P2143;

import java.io.IOException;
import java.util.*;

public class Test {

    // N - arrayNul1, M - M, result 동일
    // array1 = array2[0] array2 = array2[0]
    static long T, result;
    static int N,M;
    static long[][] array1,array2;
    static long boundary1 , boundary2;
    static ArrayList<Long> arrayList1, arrayList2;

    public static void main(String[] args) throws Exception{
        boundary1 = 1000000;
        boundary2 = 100;
        while(true){
            long seed = System.currentTimeMillis();
            Random rand = new Random(seed);

            T = rand.nextInt(30) * randLongSign();
            result = 0;

            N = rand.nextInt(5)+1;
            array1 = new long[N][];
            arrayList1 = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                array1[i] = new long[N];
                array1[i][i] = rand.nextInt(10)* randLongSign();
                arrayList1.add(array1[i][i]);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N-i-1; j++) {
                    array1[j][i+j+1] = array1[j+1][i+j+1] + array1[j][i+j];
                    arrayList1.add(array1[j][i+j+1]);
                }
            }

            M = rand.nextInt(5)+1;
            array2 = new long[M][];
            arrayList2 = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                array2[i] = new long[M];
                array2[i][i] = rand.nextInt(10)* randLongSign();
                arrayList2.add(array2[i][i]);
            }


            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M-i-1; j++) {
                    array2[j][i+j+1] = array2[j+1][i+j+1] + array2[j][i+j];
                    arrayList2.add(array2[j][i+j+1]);
                }
            }

            long result1 = a();
            long result2 = b();
            if(result1 != result2){
                System.out.println(result1 + " "+result2);
                System.out.println(T);
                System.out.println(N);
                for (int i = 0; i < N; i++) {
                    System.out.print(array1[i][i] + " ");
                }
                System.out.println();
                System.out.println(M);
                for (int i = 0; i < M; i++) {
                    System.out.print(array2[i][i] + " ");
                }
                System.out.println();
                break;
            }
        }

    }

    public static long b() throws IOException{

            List<Long> subA = new ArrayList<>();
            List<Long> subB = new ArrayList<>();

            //subA 구하기
            for (int i = 0; i < N; i++) {
                long sum = array1[i][i];
                subA.add(sum);
                for (int j = i + 1; j < N; j++) {
                    sum += array1[j][j];
                    subA.add(sum);
                }
            }
            //subB 구하기
            for (int i = 0; i < M; i++) {
                long sum = 0;
                for (int j = i; j < M; j++) {
                    sum += array2[j][j];
                    subB.add(sum);
                }
            }

            //subA, subB 정렬하기
            Collections.sort(subA);
            Collections.sort(subB, Comparator.reverseOrder());

            long result2 = 0;
            int ptA = 0;
            int ptB = 0;
            while (true) {

                long currentA = subA.get(ptA);
                long currentB = subB.get(ptB);

                //currentB == target -> subA, subB 같은 수 개수 체크 -> 답구하기. ptA+ ptB+
                if ((currentA + currentB) == T) {
                    long countA = 0;
                    long countB = 0;
                    while (ptA < subA.size() && subA.get(ptA) == currentA){
                        countA++;
                        ptA++;
                    }
                    while (ptB < subB.size() && subB.get(ptB) == currentB){
                        countB++;
                        ptB++;
                    }
                    result2 += countA * countB;
                }
                //currentB > target -> ptB++
                else if ((currentA + currentB) >T) {
                    ptB++;
                }
                //currentB < target -> ptA++
                else {
                    ptA++;
                }

                //탈축 조건
                if (ptA == subA.size() || ptB == subB.size()) {
                    break;
                }
            }

            return result2;

    }

    public static long a() throws IOException {



        Collections.sort(arrayList1);
        Collections.sort(arrayList2);



        // arrayList1를 for문으로 돌려서 이분탐색하여 찾아냄
        for (int i = 0; i < arrayList1.size(); i++) {
            result+= BS(0,arrayList2.size()-1,T-arrayList1.get(i));
        }

        return result;
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

    public static long randLongSign(){
        long seed = System.currentTimeMillis();
        Random rand = new Random(seed);
        if(rand.nextBoolean()){
            return -1;
        }else{
            return 1;
        }
    }
    public static long randIntSign(){
        long seed = System.currentTimeMillis();
        Random rand = new Random(seed);
        if(rand.nextBoolean()){
            return -1;
        }else{
            return 1;
        }
    }
}
