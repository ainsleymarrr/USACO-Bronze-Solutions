//package usaco;

import java.util.*;
public class WalkingHome {
	
//	static boolean canReach(int k,char[][] a,String dir,int r,int c,int n) {
//		if(k<0) return false;
//		if(r<0||c<0||c>=n||r>=n) return false;
//		if(a[r][c]=='H') return false;
//		if(r==n-1&&c==n-1&&k==0) return true;
//		if(r==n-1&&c==n-1&&k!=0) return false;
//		boolean result=false;
//		if(dir.equals("R")) {
//			result=canReach(k,a,"R",r,c+1,n);
//		}else result=canReach(k,a,"D",r+1,c,n);
//		if(!result&&k>0) {
//			if(dir.equals("R")) {
//				result=canReach(k-1,a,"D",r+1,c,n);
//			}else result=canReach(k-1,a,"R",r,c+1,n);
//		}
//		
//		return result;
//	}
	static int paths(int k,char[][] a,String dir,int r,int c,int n,boolean first) {
		if(k<0) return 0;
		if(r<0||c<0||r>=n||c>=n) return 0;
		if(a[r][c]=='H') return 0;
		if(r==n-1&&c==n-1) return 1;
		int result=0;
		if(dir.equals("R")) {
			result+=paths(k,a,"R",r,c+1,n,false);
			//System.out.print(a[r][c]);
			
		}
		else if(dir.equals("D")) {
			result+=paths(k,a,"D",r+1,c,n,false);
			//System.out.print(a[r][c]);
			
		}
		if(k>0&&first==false) {
			if(dir.equals("R")) result+=paths(k-1,a,"D",r+1,c,n,false);
			//System.out.print(a[r][c]);
			else if(dir.equals("D")) result+=paths(k-1,a,"R",r,c+1,n,false);
			//System.out.print(a[r][c]);
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		//ArrayList<char[][]> subCases=new ArrayList<>();
		for(int i=0;i<t;i++) {
			int n=in.nextInt();
			int k=in.nextInt();
			char[][] subcase=new char[n][n];
			for(int r=0;r<n;r++) {
				String a=in.next();
				for(int c=0;c<n;c++) {
					subcase[r][c]=a.charAt(c);
				}
			}
			
			int result=paths(k,subcase,"R",0,0,n,true)+paths(k,subcase,"D",0,0,n,true);
			
			System.out.println(result);

		}
	}

}
