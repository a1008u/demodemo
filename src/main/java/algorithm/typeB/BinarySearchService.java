package algorithm.typeB;

import typeA.Make;

public class BinarySearchService {
	
	public int[] bsmake(int tail){
		
		System.out.println("====バイナリーサーチ前====");
		
		int[] numlist = new int[tail];
		Make make = new Make();
		make.make(numlist, tail);
		
		return numlist;
	}

}
