package algorithm.typeD;

import typeA.Make;

public class SSSMakeService {
	public int[] SSSmake(int tail){
		//準備
		int[] numlist = new int[tail];
		
		//ハッシュ値を利用する前の段階
		Make make = new Make();
		make.make(numlist, tail);
		
		return numlist;
	}
}
