//package usaco;

import java.util.*;

public class herdle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		char[][] ans=new char[3][3];
		char[][] in=new char[3][3];
		for(int i=0;i<3;i++) {
			ans[i]=sc.next().toCharArray();
		}
		for(int i=0;i<3;i++) {
			in[i]=sc.next().toCharArray();
		}
		sc.close();
		
//		int g=0;
//		int y=0;
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<3;j++) {
//				if(ans[i][j]==in[i][j]) {
//					g++;
//					ans[i][j]='!';
//					in[i][j]='!';
//				}
//			}
//		}
		
		HashMap<Character,Integer> a=new HashMap<>();
		HashMap<Character,Integer> input=new HashMap<>();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(a.containsKey(ans[i][j])) {
					a.replace(ans[i][j],a.get(ans[i][j])+1);
				}else a.put(ans[i][j], 1);
				if(input.containsKey(in[i][j])) {
					input.replace(in[i][j],input.get(in[i][j])+1);
				}else input.put(in[i][j], 1);
			}
		}
		
		int g=0;
		int y=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(ans[i][j]==in[i][j]) {
					g++;
					a.replace(ans[i][j],a.get(ans[i][j])-1);
					input.replace(in[i][j],input.get(in[i][j])-1);
				}
			}
		}
		
		for(char x:a.keySet()) {
			for(char z:input.keySet()) {
				if(x==z) {
					y+=Math.min(a.get(x), input.get(z));
				}
			}
		}
		
		System.out.println(g);
		System.out.println(y);

	}

}
