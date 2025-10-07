//package usaco;

import java.util.*;

public class ComfortableCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int comfortable=0;
		int[][] grid=new int[1001][1001];
		for(int i=0;i<n;i++) {
			int x=in.nextInt();
			int y=in.nextInt();
			int neighbors=0;
			if(x>0) {
				if(grid[x-1][y]!=0) {
					neighbors++;
					if(grid[x-1][y]==4) {
						grid[x-1][y]=5;
						comfortable--;
					}else {
						grid[x-1][y]++;
						if(grid[x-1][y]==4) {
							comfortable++;
						}
					}
				}
			}
			if(x<1000) {
				if(grid[x+1][y]!=0) {
					neighbors++;
					if(grid[x+1][y]==4) {
						grid[x+1][y]=5;
						comfortable--;
					}else {
						grid[x+1][y]++;
						if(grid[x+1][y]==4) {
							comfortable++;
						}
					}
				}
			}
			if(y>0) {
				if(grid[x][y-1]!=0) {
					neighbors++;
					if(grid[x][y-1]==4) {
						grid[x][y-1]=5;
						comfortable--;
					}else {
						grid[x][y-1]++;
						if(grid[x][y-1]==4) {
							comfortable++;
						}
					}
				}
			}
			if(y<1000) {
				if(grid[x][y+1]!=0) {
					neighbors++;
					if(grid[x][y+1]==4) {
						grid[x][y+1]=5;
						comfortable--;
					}else {
						grid[x][y+1]++;
						if(grid[x][y+1]==4) {
							comfortable++;
						}
					}
				}
			}
			grid[x][y]=neighbors+1;
			
			System.out.println(comfortable);
		}
	}

}
