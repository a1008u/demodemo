package algorithm.typeG;

import typeF.ISort_Blogic;

public class QSMethodService {
	
public void qsmethod(int[] QSnumlist, int tail) {
		
		System.out.println("=====クイックソート後=====");
	
		//クイックソート
		QSort_Blogic QSBlogic = new QSort_Blogic();
		QSBlogic.qSort(QSnumlist, 0,tail-1);

		//結果
		for(int i=0 ; i<QSnumlist.length; ++i){
			int ii = i+ 1;
			if(i>4 && i%5 == 0){
				System.out.println("【"+ ii +"】 " 
									+ QSnumlist[i] + " " );
			}else{
				System.out.print("【"+ ii +"】 " 
									+ QSnumlist[i] + " " );
			}
		}
	}

}
