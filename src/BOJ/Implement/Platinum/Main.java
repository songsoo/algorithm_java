package BOJ.Implement.Platinum;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][][] cube;
    static int [][][] faceLink = {
            {
                    {1,0,0},{1,0,1},{1,0,2},
                    {4,0,0},{4,0,1},{4,0,2},
                    {3,0,0},{3,0,1},{3,0,2},
                    {2,0,0},{2,0,1},{2,0,2},
            },
            {
                    {0,0,2},{0,1,2},{0,2,2},
                    {2,0,2},{2,1,2},{2,2,2},
                    {5,0,2},{5,1,2},{5,2,2},
                    {4,2,0},{4,1,0},{4,0,0},
            },
            {
                    {0,2,0},{0,2,1},{0,2,2},
                    {3,2,2},{3,1,2},{3,0,2},
                    {5,0,2},{5,0,1},{5,0,0},
                    {1,0,0},{1,1,0},{1,2,0},
            },
            {
                    {0,0,0},{0,1,0},{0,2,0},
                    {4,2,2},{4,1,2},{4,0,2},
                    {5,0,0},{5,1,0},{5,2,0},
                    {2,0,0},{2,1,0},{2,2,0},
            },
            {
                    {0,0,0},{0,0,1},{0,0,2},
                    {1,0,2},{1,1,2},{1,2,2},
                    {5,2,2},{5,2,1},{5,2,0},
                    {3,2,0},{3,1,0},{3,0,0},
            },
            {
                    {1,2,0},{1,2,1},{1,2,2},
                    {2,2,0},{2,2,1},{2,2,2},
                    {3,2,0},{3,2,1},{3,2,2},
                    {4,2,0},{4,2,1},{4,2,2},
            },
    };

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("D:\\IntelliJ\\algo\\src\\Test\\input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            cube =  new char[][][]{
//                    {
//                            {'1','2','3'},
//                            {'4','5','6'},
//                            {'7','8','9'},
//                    },
//                    {
//                            {'a','b','c'},
//                            {'d','e','f'},
//                            {'g','h','i'},
//                    },
//                    {
//                            {'j','k','l'},
//                            {'m','n','o'},
//                            {'p','q','r'},
//                    },
//                    {
//                            {'A','B','C'},
//                            {'D','E','F'},
//                            {'G','H','I'},
//                    },
//                    {
//                            {'J','K','L'},
//                            {'M','N','O'},
//                            {'P','Q','R'},
//                    },
//                    {
//                            {'!','@','#'},
//                            {'$','%','^'},
//                            {'&','*','('},
//                    },
                    {
                            {'w','w','w'},
                            {'w','w','w'},
                            {'w','w','w'},
                    },
                    {
                            {'b','b','b'},
                            {'b','b','b'},
                            {'b','b','b'},
                    },
                    {
                            {'r','r','r'},
                            {'r','r','r'},
                            {'r','r','r'},
                    },
                    {
                            {'g','g','g'},
                            {'g','g','g'},
                            {'g','g','g'},
                    },
                    {
                            {'o','o','o'},
                            {'o','o','o'},
                            {'o','o','o'},
                    },
                    {
                            {'y','y','y'},
                            {'y','y','y'},
                            {'y','y','y'},
                    },

            };
            int N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                String cur = st.nextToken();
                char a = cur.charAt(0);
                char b = cur.charAt(1);
                rotate(a,b);

            }
            printTop(0);
        }
    }
    public static void rotate(char face, char direction){
        int faceIndex = getFaceIndex(face);
        boolean directionIndex = direction=='+'?true:false;
        rotateFace(faceIndex, directionIndex);
        rotateSide(faceIndex, directionIndex);
    }
    public static void rotateFace(int i, boolean direction){
        char temp[][] = new char[3][3];
        if(direction){
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    temp[j][k]=cube[i][2-k][j];
                }
            }
        }else{
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    temp[j][k]=cube[i][k][2-j];
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                cube[i][j][k] = temp[j][k];
            }
        }
    }
    /*
    * {
          {1,2,0},
          {1,2,1},
          {1,2,2},
          {2,2,0}
          {2,2,1}
          {2,2,2},
          {3,2,0}
          {3,2,1},{3,2,2},
          {4,2,0},{4,2,1},{4,2,2},
      }
    * */
    public static void rotateSide(int i, boolean direction){
        char temp [] = new char[3];
        for (int j = 0; j < 3; j++) {
                int i2 = faceLink[i][j][0];
                int j2 = faceLink[i][j][1];
                int k2 = faceLink[i][j][2];
                temp[j] = cube[i2][j2][k2];
        }

        if(direction){
            for (int j = 0; j < 9; j++) {
                int i2 = faceLink[i][j][0];
                int j2 = faceLink[i][j][1];
                int k2 = faceLink[i][j][2];
                int i3 = faceLink[i][j+3][0];
                int j3 = faceLink[i][j+3][1];
                int k3 = faceLink[i][j+3][2];
                cube[i2][j2][k2] = cube[i3][j3][k3];
            }
            for (int j = 9; j < 12; j++) {
                int i2 = faceLink[i][j][0];
                int j2 = faceLink[i][j][1];
                int k2 = faceLink[i][j][2];
                cube[i2][j2][k2] = temp[j-9];
                cube[i2][j2][k2] = temp[j-9];
                cube[i2][j2][k2] = temp[j-9];
            }
        }else{

            //0,1,2에 9,10,11 할당
            //6~11은 자신 -3할당
            //3~5에 temp할당
            for (int j = 0; j < 3; j++) {
                int i2 = faceLink[i][j][0];
                int j2 = faceLink[i][j][1];
                int k2 = faceLink[i][j][2];
                int i3 = faceLink[i][j+9][0];
                int j3 = faceLink[i][j+9][1];
                int k3 = faceLink[i][j+9][2];
                cube[i2][j2][k2] = cube[i3][j3][k3];
            }

            for (int j = 11; j >= 6; j--) {
                int i2 = faceLink[i][j][0];
                int j2 = faceLink[i][j][1];
                int k2 = faceLink[i][j][2];
                int i3 = faceLink[i][j-3][0];
                int j3 = faceLink[i][j-3][1];
                int k3 = faceLink[i][j-3][2];
                cube[i2][j2][k2] = cube[i3][j3][k3];

            }
            for (int j = 3; j < 6; j++) {
                int i2 = faceLink[i][j][0];
                int j2 = faceLink[i][j][1];
                int k2 = faceLink[i][j][2];
                cube[i2][j2][k2] = temp[j-3];
                cube[i2][j2][k2] = temp[j-3];
                cube[i2][j2][k2] = temp[j-3];
            }

        }

    }
    public static int getFaceIndex(char face){
        if(face=='U'){
            return 0;
        }else if(face=='R'){
            return 1;
        }else if(face=='F'){
            return 2;
        }else if(face=='L'){
            return 3;
        }else if(face=='B'){
            return 4;
        }else if(face=='D'){
            return 5;
        }
        return -1;
    }

    public static void printTop(int face){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[face][i][j]);
            }
            System.out.println();
        }
    }
}
