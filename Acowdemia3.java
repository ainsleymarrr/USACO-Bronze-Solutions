//package usaco;

import java.util.*;

public class Acowdemia3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		char[][] grid=new char[n][m];
		for(int i=0;i<n;i++) {
			grid[i]=in.next().toCharArray();
		}
		in.close();
		
		int friends=0;
		for(int r=0;r<n;r++) {
			for(int c=0;c<m;c++) {
				if(grid[r][c]=='G') {
					boolean h=c>0&&c<m-1&&grid[r][c-1]=='C'&&grid[r][c+1]=='C';
					boolean v=r>0&&r<n-1&&grid[r-1][c]=='C'&&grid[r+1][c]=='C';
					if(h||v) {
						friends++;
						grid[r][c]='.';
					}
				}
			}
		}
		for(int r=0;r<n;r++) {
			for(int c=0;c<m;c++) {
				if(grid[r][c]=='C') {
					if(r<n-1&&c>0&&grid[r+1][c-1]=='C') {
						if(grid[r][c-1]=='G') {
							grid[r][c-1]='.';
							friends++;
						}
						else if(grid[r+1][c]=='G') {
							grid[r+1][c]='.';
							friends++;
						}
					}
					if(r<n-1&&c<m-1&&grid[r+1][c+1]=='C') {
						if(grid[r][c+1]=='G') {
							grid[r][c+1]='.';
							friends++;
						}
						else if(grid[r+1][c]=='G') {
							grid[r+1][c]='.';
							friends++;
						}
					}
				}
				
			}
		}
		System.out.print(friends);
	}

}
