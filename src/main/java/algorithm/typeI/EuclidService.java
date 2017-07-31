package algorithm.typeI;

import typeA.Make;

public class EuclidService {
	
	public void numcheck(int bignum, int smallnum){
		
		System.out.println("====①数の大きさチェック====");
		
		if(!(smallnum<bignum)){
			int tempnum = bignum;
			bignum = smallnum;
			smallnum = tempnum;
		}
		
		System.out.println("大【"+ bignum + "】");
		System.out.println("小【"+ smallnum + "】");
	}

}
