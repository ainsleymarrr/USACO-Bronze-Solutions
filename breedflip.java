//package usaco;

import java.util.*;
import java.io.*;
 
public class breedflip {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("breedflip.in"));
       int n=in.nextInt();
    String a=in.next();
    String b=in.next();
    in.close();
    
    ArrayList<ArrayList<Integer>> index=new ArrayList<>();
    ArrayList<Integer> x=new ArrayList<>();
    index.add(x);
    int ai=0;
    for(int i=0;i<n;i++) {
    	if(a.charAt(i)!=b.charAt(i)) index.get(ai).add(i);
    	else {
    		ArrayList<Integer> y=new ArrayList<>();
    		index.add(y);
    		ai++;
    	}
    }
    int result = 0;
    
    for(ArrayList<Integer> o:index) {
    	if(o.size()!=0) result++;
    	
    }
    PrintWriter out = new PrintWriter(new File("breedflip.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
}
