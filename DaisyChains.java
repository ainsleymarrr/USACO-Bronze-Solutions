//package usaco;

import java.util.*;

public class DaisyChains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] p=new int[n];
		for(int i=0;i<n;i++) {
			p[i]=in.nextInt();
		}
		in.close();
		int result=0;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				ArrayList<Integer> a=new ArrayList<>();
				int f=0;
				int t=0;
				for(int h=i;h<=j;h++) {
					a.add(p[h]);
					t+=p[h];
					f++;
				}
				if(a.contains(t/f)&&t%f==0) {
					result++;
				}
			}
		}
		System.out.print(result);

	}

}
