//package usaco;

import java.util.*;
import java.io.*;

public class SocialDistancing {
	
	static int nextInfected(int current, int min,int[] s, Integer[] x) {
		int result=-1;
		List<Integer> X=new ArrayList<>(Arrays.asList(x));
		for(int i=x[current]+1;i<x[current]+min;i++) {
			if(Arrays.asList(x).contains(i)) {
//				System.out.println("yeah");
				int j=Arrays.asList(x).indexOf(i);
				if(s[j]==1) result=j;
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//read
		Scanner in=new Scanner(new File("socdist2.in"));
		int n=in.nextInt();
		Integer[] x=new Integer[n];
		int[] s=new int[n];
		for(int i=0;i<n;i++) {
			x[i]=in.nextInt();
			s[i]=in.nextInt();
		}
		in.close();
		
		//sort
		Integer[] sortedx=Arrays.copyOf(x, n);
		Arrays.sort(sortedx);
		int[] sorteds=Arrays.copyOf(s, n);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(sortedx[i]==x[j]) {
					sorteds[i]=s[j];
//					System.out.print(sorteds[i]);
//					System.out.print(sortedx[i]);
				}
			}
		}
		
		
		//find minimum distance
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++) {
			if((sorteds[i]==0&&sorteds[i+1]==1)||(sorteds[i]==1&&sorteds[i+1]==0)) {
				int m=Math.abs(sortedx[i]-sortedx[i+1]);
				if(min>m) min=m;
			}
		}
		
		//
		int result=0;
		int index=0;
		while(index<n){
			if(sorteds[index]==1) {
				int i=nextInfected(index,min,sorteds,sortedx);
//				System.out.print(nextInfected(index,min,sorteds,sortedx));
				if(i==-1) {
					result++;
					index++;
				}else {
					index=i;
				}
			}else index++;
		}
		PrintWriter out=new PrintWriter(new File("socdist2.out"));
		out.print(result);
		out.close();
		System.out.print(result);
//		System.out.print(nextInfected(0,3,sorteds,sortedx));
	}

}
