package algorithm.typeF;

public class ISMethodService {

	public void ismethod(int[] iSnumlist, int tail) {
		
		//単純挿入法
		ISort_Blogic ISBlogic = new ISort_Blogic();
		ISBlogic.iSort(iSnumlist, tail);

		//結果
		for(int i=0 ; i<iSnumlist.length; ++i){
			int ii = i+ 1;
			if(i>4 && i%5 == 0){
				System.out.println("【"+ ii +"】 " 
									+ iSnumlist[i] + " " );
			}else{
				System.out.print("【"+ ii +"】 " 
									+ iSnumlist[i] + " " );
			}
		}
	}
}
