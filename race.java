//package usaco;

import java.util.*;
import java.io.*;

public class race {
	static int maxspeed(int a, int b) {
		//x2-a2+a=b
		//x2=b+a2-a
		return (int)Math.sqrt(b+a*a-a);
//		if(r>a) return (int)Math.sqrt(b-a*a-a);
//		else return -1;
	}
	static int sum(int a,int b) {
		return a*a-b*b+b;
	}
	static int time(int a,int b) {
		return 2*(b-a)+1;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(new File("race.in"));
		PrintWriter out=new PrintWriter(new File("race.out"));
		int k=in.nextInt();
		int n=in.nextInt();
		for(int t=0;t<n;t++) {
			int c=in.nextInt();
			int time=0;
			int speed=0;
			int total=0;
			int x=0;
			while(total<k) {
				if(speed<c) {
					speed++;
					total+=speed;
					time++;
//					System.out.println(total);
					
				}
				else if(speed==c) {
					if(x!=0) {
						int remain=k-total;
						int a=0;
						if(remain%x!=0) {
							a=remain/x+1;
						}else {
							a=remain/x;
						}
						total+=a*x;
						time+=a;
					}else {
//						System.out.print(k-total);
						x=maxspeed(c,k-total+c);
						time+=time(c,x)-1;
						total+=sum(x,c)-c;
						
//						System.out.println(x);
					}
					
				}
			}
			System.out.println(time);
			out.println(time);
			
		}
		in.close();
		out.close();
	}
	

}
