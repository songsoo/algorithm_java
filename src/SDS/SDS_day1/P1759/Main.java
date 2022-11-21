package SDS.SDS_day1.P1759;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int L, C, selectedCount=0;
    static char[] words;
    static boolean[] visited;
    static List<String> result;

    public static boolean isCollection(char c) {
        if(c=='a'||c=='i'||c=='e'||c=='o'||c=='u') {
            return true;
        }else {
            return false;
        }
    }

    public static void dfs(int index, int ja, int mo, int current, String pwd) {
        if(index==L) {
            if(ja>=2 && mo>=1) {
                result.add(pwd);
            }
        }else {
            for(int i=current+1;i<C;i++) {
                if(isCollection(words[i])) {
                    dfs(index+1, ja, mo+1,i,pwd+words[i]);
                }else {
                    dfs(index+1, ja+1, mo,i,pwd+words[i]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/SDS.SDS_day1/P1759/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line," ");

        L = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());

        result = new LinkedList<>();
        words = new char[C];
        visited = new boolean[C];

        line = bf.readLine();
        st = new StringTokenizer(line," ");

        for(int i=0;i<C;i++) {
            words[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(words);

        //더미 사용, 스타트를 별도로 지정없이
        dfs(0,0,0,-1,"");

        for(String pwd: result) {
            System.out.println(pwd);
        }

    }


	/*
	static int L, C, selectedCount=0;
	static char[] words;
	static boolean[] visited;


	public static boolean isCollection(char c) {
		if(c=='a'||c=='i'||c=='e'||c=='o'||c=='u') {
			return true;
		}else {
			return false;
		}
	}

	public static void dfs(int index) {
		//1.체크인
		visited[index]=true;
		selectedCount++;
		//2.목적지인가
		if(selectedCount==L) {
			int count = 0;
			int collection = 0;
			int consonant = 0;
			char arr[] = new char[L];
			for(int i=0;i<C;i++) {
				if(visited[i]) {
					arr[count] = words[i];
					count++;
					if(isCollection(words[i])) {
						collection++;
					}else {
						consonant++;
					}
				}
			}
			if(collection>=1&&consonant>=2) {
				Arrays.sort(arr);
				for(int i=0;i<L;i++) {
					System.out.print(arr[i]);
				}
				System.out.println();
			}

		}else {
			for(int i=0;i<C;i++) {
				if(words[index]<words[i]) {
					dfs(i);
				}
			}
		}
		//3.연결된 곳 순서대로
		// 4.갈 수 있는가
		//  5.간다
		//6.체크아웃
		visited[index]=false;
		selectedCount--;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		StringTokenizer st = new StringTokenizer(line," ");

		L = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());

		words = new char[C];
		visited = new boolean[C];

		line = bf.readLine();
		st = new StringTokenizer(line," ");

		for(int i=0;i<C;i++) {
			words[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(words);

		for(int i=0;i<C;i++) {
			dfs(i);
		}


	}
	*/

}
