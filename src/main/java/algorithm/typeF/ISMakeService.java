package algorithm.typeF;

import typeA.Make;

public class ISMakeService {
	
	public int[] ismake(int tail){
		//準備
		int[] numlist = new int[tail];
		
		//ハッシュ値を利用する前の段階
		Make make = new Make();
		make.make(numlist, tail);
		
		return numlist;
	}
}
