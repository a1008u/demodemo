package algorithm.typeD;
public class SSSMethodService {
	public void SSSmethod(int[] SSSnumlist,int tail){
		
		System.out.println("要素を昇順に並び替えます。");
		
		//単純選択法
		SSSMethod_Sort_Blogic SSSMSBlogic = new SSSMethod_Sort_Blogic ();
		SSSMSBlogic.SSSMSort(SSSnumlist, tail);
		
		//結果
		for(int i=0 ; i<SSSnumlist.length; ++i){
			int ii = i+ 1;
			if(i>4 && i%5 == 0){
				System.out.println("【"+ ii +"】 " 
									+ SSSnumlist[i] + " " );
			}else{
				System.out.print("【"+ ii +"】 " 
									+ SSSnumlist[i] + " " );
			}
		}
	}
}
