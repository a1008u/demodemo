package algorithm.typeG;

import typeA.Make;

public class QSMakeService {
	
	public int[] qsmake(int tail){
		//準備
		int[] numlist = new int[tail];
		
		System.out.println("====クイックソート前====");
		
		//ハッシュ値を利用する前の段階
		Make make = new Make();
		make.make(numlist, tail);
		
		return numlist;
	}

}
