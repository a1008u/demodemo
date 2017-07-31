package algorithm.typeI;

public class EuclidMethodService {
	
	public void emethod(int bignum, int smallnum) {
		
		System.out.println("=====②ユークリッドの互除法=====");
	
		//ユークリッドの互除法
		Euclid_Blogic EuclidBlogic = new Euclid_Blogic();
		int result = EuclidBlogic.echeck(bignum, smallnum);

		//結果
		System.out.println("最大公約数は【" + result + "】");

	}
}
