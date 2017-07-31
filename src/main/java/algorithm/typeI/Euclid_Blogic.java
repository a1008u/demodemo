package algorithm.typeI;

public class Euclid_Blogic {

	public int echeck(int bignum, int smallnum) {
		
		//余りを求める
		int num = bignum % smallnum;
		
		//余りが「0」となるまで処理を繰り返す
		while(num != 0){
			bignum = smallnum;
			smallnum = num;
			num = bignum % smallnum;
		}
		
		//最大公約数を返す
		return smallnum;
	}
}
