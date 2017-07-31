package algorithm.typeH;

public class SOEMethodService {
	
	public void sqemethod(int[] SOElist, int tail) {
		
		System.out.println("=====②エラクトテネスのふるまい後：素数の数=====");
	
		//エクトレネスのふるい
		SQE_Blogic SQEBlogic = new SQE_Blogic();
		SQEBlogic.sqeSort(SOElist, tail);

		//結果
		int sum = 0;
		int displaycount = 0; 
		for(int indexnum=2 ; indexnum<SOElist.length; ++indexnum){
			if(SOElist[indexnum] == 0){
				++displaycount; 
				String result = "【"+ indexnum +"】 " 
						+ SOElist[indexnum] + " " ;
				
				if(displaycount > 5){
					System.out.printf("%8S\n", result );
					displaycount = 0;
				}else{
					System.out.printf("%8S", result);
				}
				
				++sum;
			}
		}
		
		System.out.println();
		System.out.println("素数の数【" + sum + "】");
	}
}
