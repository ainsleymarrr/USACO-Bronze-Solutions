//package usaco;

import java.util.*;
import java.io.*;

public class FamilyTree {
	static HashMap<String,String> buildMap(int n, Scanner sc){
		HashMap<String,String> cows=new HashMap<String,String>();
		for(int i=0;i<n;i++) {
			String x=sc.next();
			String y=sc.next();
			cows.put(y, x);
			
		}
		
		return cows;
		
	}
	
	static boolean isSiblings(String cowA,String cowB,HashMap<String,String> cows) {
		if(cows.containsKey(cowA)==false||cows.containsKey(cowB)==false) return false;
		if(cows.get(cowA).equals(cows.get(cowB))) return true;
		else return false;
	}
	
	static ArrayList<String> buildList(HashMap<String,String> cows, String cow){
		ArrayList<String> ca=new ArrayList<>();
		String now=cow;
		while(cows.containsKey(now)) {
			ca.add(cows.get(now));
			now=cows.get(now);
		}
		return ca;
	}
	
	static String directRelation(ArrayList<String> c,String cow) {
		int index=c.indexOf(cow);
		if(index!=-1) {
			String relation="";
			if(index==0) relation="mother";
			else if(index==1) relation="grand-mother";
			else {
				relation="grand-mother";
				for(int i=index;i>1;i--) {
					relation="great-"+relation;
				}
			}
			return relation;
		}
		else return "";
	}
	
	static String Aunt(ArrayList<String> c,String cow,HashMap<String,String> cows) {
		for(String i:c) {
			if(isSiblings(i, cow, cows)) {
				int index=c.indexOf(i);
				String relation="aunt";
				if(index==0) return relation;
				else {
					for(int j=index;j>0;j--) {
						relation="great-"+relation;
					}
					return relation;
				}
			}
		}
		return "";
	}
	


	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(new File("family.in"));
		int n=sc.nextInt();
		String cowA=sc.next();
		String cowB=sc.next();
		HashMap<String,String> cows=buildMap(n,sc);
		sc.close();
		
		String result="";
		if(cows.get(cowA).equals(cows.get(cowB))) result="SIBLINGS";
		ArrayList<String> ca=buildList(cows,cowA);
		ArrayList<String> cb=buildList(cows,cowB);
		
		String relationA=directRelation(ca,cowB);
		String relationB=directRelation(cb,cowA);
		if(!relationA.equals("")) result=cowB+" is the "+relationA+" of "+cowA;
		else if(!relationB.equals("")) result=cowA+" is the "+relationB+" of "+cowB;
		
		String auntA=Aunt(ca,cowB,cows);
		String auntB=Aunt(cb,cowA,cows);
		if(!auntA.equals("")&&result.equals("")) result=cowB+" is the "+auntA+" of "+cowA;
		else if(!auntB.equals("")&&result.equals("")) result=cowA+" is the "+auntB+" of "+cowB;
		
		for(String i:ca) {
			for(String j:cb) {
				if(i.equals(j)) {
					if(result.equals("")) result="COUSINS";
					break;
				}
			}
		}
		if(result.equals("")) result="NOT RELATED";
		
		PrintWriter out = new PrintWriter(new File("family.out"));
        System.out.println(result);
        out.println(result);
        out.close();

	}

}