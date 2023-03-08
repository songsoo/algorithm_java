package Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main2 {
	static int N;
	static int [][] hitter;
	static int M=9; //9명 
	static int [] p= {2,3,4,5,6,7,8,9};
	static int [] base;
	static int max;
	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("C:\\Users\\SSAFY\\IdeaProjects\\algorithm_java\\src\\Test\\Input.txt"));
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();   // inning
		hitter=new int[N][M];// M 타자수 9명 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				hitter[i][j]=scann.nextInt();
			}
		}
		max=-1;
		do {
			base=new int[4];
			int [] player=new int[M];
			for (int i = 0; i < M; i++) {
				if(i<3) {
					player[i]=p[i];
				}else if(i==3) {
					player[i]=1;
				}else if(i>=4) {
					player[i]=p[i-1];
				}
			}
			int tot=0;
			int index=0;
			int out=0;
			for (int i = 0; i < N; i++) {
				aa: while(out!=3) {
					for (int j = (index)%9; j < 9; j++) {
						if(hitter[i][player[j]-1]==0) {
							out++;
						}else if(hitter[i][player[j]-1]==4) {
							for (int k = 1; k < 4; k++) {
								if(base[k]==1) {  // base에 있을때
									tot++;
								}
							}
							tot++;                // 자신
							base=new int[4];
						}else if(hitter[i][player[j]-1]==1){ //1루타
							
							if(base[1]==1) {
								if(base[2]==1) {
									if(base[3]==1) {  //1 2 3
										base[3]=1;
										base[2]=1;
										base[1]=1;
										tot++; 
									}else {           //1 2 
										base[3]=1;
										base[2]=1;
										base[1]=1;
									}
								}else {    //2x
									if(base[3]==1) {  //1 3
										base[3]=0;
										base[2]=1;
										base[1]=1;
										tot++; 
									}else {           // 1
										base[3]=0;
										base[2]=1;
										base[1]=1;
									}
								}
							}else {        //1x
								if(base[2]==1) {
									if(base[3]==1) {  // 2 3
										base[3]=1;
										base[2]=0;
										base[1]=1;
										tot++; 
									}else {           // 2
										base[3]=1;
										base[2]=0;
										base[1]=1;
									}
								}else {
									if(base[3]==1) {  //3
										base[3]=0;
										base[2]=0;
										base[1]=1;
										tot++; 
									}else {           //x
										base[3]=0;
										base[2]=0;
										base[1]=1;
									}
								}	
							}
						}else if(hitter[i][player[j]-1]==2){ //2루타
							if(base[1]==1) {
								if(base[2]==1) {
									if(base[3]==1) {  //1 2 3
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++; 
										tot++; 
									}else {           //1 2 
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++; 
									}
								}else {    //2x
									if(base[3]==1) {  //1 3
										base[3]=1;
										base[2]=1;
										base[1]=0;
										tot++; 
									}else {           // 1
										base[3]=1;
										base[2]=0;
										base[1]=0;
									}
								}
							}else {        //1x
								if(base[2]==1) {
									if(base[3]==1) {  // 2 3
										base[3]=0;
										base[2]=1;
										base[1]=0;
										tot++; 
										tot++; 
									}else {           // 2
										base[3]=0;
										base[2]=1;
										base[1]=0;
										tot++;
									}
								}else {
									if(base[3]==1) {  //3
										base[3]=0;
										base[2]=1;
										base[1]=0;
										tot++; 
									}else {           //x
										base[3]=0;
										base[2]=1;
										base[1]=0;
									}
								}	
							}
						}else if(hitter[i][player[j]-1]==3){ //3루타
							if(base[1]==1) {
								if(base[2]==1) {
									if(base[3]==1) {  //1 2 3
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++; 
										tot++; 
										tot++; 
									}else {           //1 2 
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++; 
										tot++; 
									}
								}else {    //2x
									if(base[3]==1) {  //1 3
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++; 
										tot++; 
									}else {           // 1
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++; 
									}
								}
							}else {        //1x
								if(base[2]==1) {
									if(base[3]==1) {  // 2 3
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++; 
										tot++; 
									}else {           // 2
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++;
									}
								}else {
									if(base[3]==1) {  //3
										base[3]=1;
										base[2]=0;
										base[1]=0;
										tot++; 
									}else {           //x
										base[3]=1;
										base[2]=0;
										base[1]=0;
									}
								}	
							}
						
						}
						if(out==3) {
							index=j+1;        // 번호 연결해서
							out=0;
							base=new int[4];  // 매 이닝마다 베이스 초기화
							break aa;
						}else if(out<3){
							index=j+1;        // 번호 연결해서
							if(index==9){
								index=0;
							}
						}
					}
				}
			}
			max=Math.max(max, tot);
		} while (np(M-2));
		System.out.println(max);
	}
	static boolean np(int size) {
		int i=size;
		while(i>0 && p[i-1]>=p[i]) i--;
		if(i==0) return false;
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int temp=p[i-1];
		p[i-1]=p[j];
		p[j]=temp;
		int k=size;
		while(i<k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		return true;
	}

}
