import java.util.*;

public class Hoofpaperscissors {
	static long combination(int s) {
		if(s < 2) return 0;
	    return s*(s-1)/2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
//		char[][] grid=new char[n][n];
		HashMap<Integer,ArrayList<Integer>> win=new HashMap<>();
		for(int i=0;i<n;i++) {
			win.put(i, new ArrayList<Integer>());
			char[] x=in.next().toCharArray();
			for(int j=0;j<x.length;j++) {
				if(x[j]=='W') {
					ArrayList<Integer> a=win.get(j);
					a.add(i);
					win.put(j, a);
				}else if(x[j]=='L') {
					ArrayList<Integer> a=win.get(i);
					a.add(j);
					win.put(i,a);
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			int l=in.nextInt()-1;
			int r=in.nextInt()-1;
			ArrayList<Integer> wl=win.get(l);
			ArrayList<Integer> wr=win.get(r);
			ArrayList<Integer> w=new ArrayList<>();
			if(wr!=null&&wl!=null) {
				for(int j:wl) {
					if(wr.contains(j)) {
						w.add(j);
					}
				}
			}
			
			int s=w.size();
			System.out.println(combination(s)*2+s+s*(n-s)*2);
		}
		in.close();
		
		
	}

}
