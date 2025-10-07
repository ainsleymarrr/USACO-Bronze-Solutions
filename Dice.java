//package usaco;

import java.util.*;

public class Dice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int T=in.nextInt();
		for(int t=0;t<T;t++) {
			int[] a=new int[4];
			int[] b=new int[4];
			int minA=Integer.MAX_VALUE;
			int maxA=0;
			int minB=Integer.MAX_VALUE;
			int maxB=0;
			for(int i=0;i<4;i++) {
				a[i]=in.nextInt();
			}
			
			for(int i=0;i<4;i++) {
				b[i]=in.nextInt();
			}
			
			int win=0;
			int lose=0;
			for(int i:a) {
				for(int j:b) {
					if(i>j) win++;
					else if(i<j) lose++;
				}
			}
			if(win<lose) {
				int[] c=a.clone();
				a=b.clone();
				b=c.clone();
//				System.out.println("b");
			}
//			else System.out.println("a");
			
			
			boolean yes=false;
			for(int i=1;i<=10;i++) {
				int winsA=0;
				int losesA=0;
				int winsB=0;
				int losesB=0;
				for(int A:a) if(A<i) winsA++;
				else if(A>i) losesA++;
				for(int B:b) if(B<i) winsB++;
				else if(B>i) losesB++;
				for(int j=1;j<=10;j++) {
					int wA2=winsA;
					int lA2=losesA;
					int wB2=winsB;
					int lB2=losesB;
					for(int A:a) if(A<j) wA2++;
					else if(A>j) lA2++;
					for(int B:b) if(B<j) wB2++;
					else if(B>j) lB2++;
					for(int x=1;x<=10;x++) {
						int wA3=wA2;
						int lA3=lA2;
						int wB3=wB2;
						int lB3=lB2;
						for(int A:a) if(A<x) wA3++;
						else if(A>x) lA3++;
						for(int B:b) if(B<x) wB3++;
						else if(B>x) lB3++;
						for(int y=1;y<=10;y++) {
							int wA4=wA3;
							int lA4=lA3;
							int wB4=wB3;
							int lB4=lB3;
							for(int A:a) if(A<y) wA4++;
							else if(A>y) lA4++;
							for(int B:b) if(B<y) wB4++;
							else if(B>y) lB4++;
							if(wA4>lA4&&wB4<lB4) {
								yes=true;
								break;
							}
						}
					}
				}
			}
			
				if(yes) System.out.println("yes");
				else System.out.println("no");		
			
			
		}
		

	}

}
