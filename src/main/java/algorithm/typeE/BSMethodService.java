package algorithm.typeE;

public class BSMethodService {
	
	public void BSmethod(int[] BSnumlist ,int tail){

		System.out.println("---単純交換法より昇順に変更----");	
		
		//単純交換法
		BSort_Blogic BSBlogic = new BSort_Blogic();
		BSBlogic.BSort(BSnumlist, tail);
		
		//結果
		for(int i=0 ; i<BSnumlist.length; ++i){
			int ii = i+ 1;
			if(i>4 && i%5 == 0){
				System.out.println("【"+ ii +"】 " 
									+ BSnumlist[i] + " " );
			}else{
				System.out.print("【"+ ii +"】 " 
									+ BSnumlist[i] + " " );
			}
		}
	}
}
