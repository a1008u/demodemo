package algorithm.typeH;

public class SQE_Blogic {

	public void sqeSort(int[] SOElist, int tail) {
		
		int tempprime = 2;
		int prime;
		
		//平方根以下の素数の倍数を取り除く
		while(tempprime * tempprime <= tail){
			
			//取り除く必要があるかをチェック
			if(SOElist[tempprime] == 0){
				
				//素数でない値に「1」を格納する(素数でないため取り除く)
				for( prime = tempprime ;prime <= tail/tempprime; ++prime){
					SOElist[tempprime * prime] =1;
				}
			}
			
			tempprime += 1;
		}
	}
}
