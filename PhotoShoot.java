//package usaco;

import java.util.*;

public class PhotoShoot {
	
//	static void swap(char[] arr,int i,int j) {
//		char temp=arr[i];
//		arr[i]=arr[j];
//		arr[j]=temp;
//	}
//	
//	static void reverse(int i,int j,char[] arr) {
//		for(int x=0;x<(j-i)/2+(j-i)%2;x++) {
//			swap(arr,i+x,j-x);
//		}
//	}
	
//	static int reverse(int n,int j,char[] arr,boolean[] swap,int t) {
//		if(j%2!=0&&arr[j]=='H') {
//			reverse(0,j,arr);
//			t++;
//			if()
//		}
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		char[] cows=in.next().toCharArray();
		in.close();
		
		String[] best=new String[n/2];
		int index=0;
		int t=0;
		int f=0;
		for(int i=0;i<n-1;i+=2) {
//			System.out.print(i);
			if(cows[i]==cows[i+1]) {
				if(cows[i]=='G') best[index]="G";
				else best[index]="H";
			}
			else if(cows[i]!=cows[i+1]) {
				if(cows[i]=='G') {
					best[index]="false";
					f++;
				}
				else{
					best[index]="true";
					t++;
				}
			}
			index++;
//			System.out.print(best[index-1]);
		}
		
		int steps=0;
		char current='f';
		for(int i=n/2-1;i>=0;i--) {
//			System.out.println(best[i]);
			if(current=='f') {
				if(best[i].equals("true")) t--;
				else if(best[i].equals("false")) {
					int temp=t;
					t=f-1;
					f=temp;
					steps++;
					current='t';
//					System.out.print(f+" ");
//					System.out.println(t);
				}
			}else if(current=='t') {
				if(best[i].equals("false")) t--;
				else if(best[i].equals("true")) {
					int temp=t;
					t=f-1;
					f=temp;
					steps++;
					current='f';
//					System.out.print(f+" ");
//					System.out.println(t);
				}
			}
			
			if(f<=0) break;
		}
		System.out.print(steps);
	}

}
