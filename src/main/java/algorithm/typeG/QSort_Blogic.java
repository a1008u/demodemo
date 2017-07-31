package algorithm.typeG;
public class QSort_Blogic {

	public void qSort(int[] QSnumlist, int left, int right){
		
		//========================
		int left2 = left + 1;
		int right2 = right;
		
		while(left2 < right2){
			//【左側の要素<基準値 && 左のインデックス < 末尾】============
			while(QSnumlist[left2]<QSnumlist[left] && left2 < right){
				left2 += 1;
			}
			
			//【右側の要素>=基準値 && 右のインデックス > 首尾 】============
			while(QSnumlist[right2]>=QSnumlist[left] && right2 >left){
				right2 -= 1;
			}
			
			//【入替】=============
			if( left2 < right2 ){
				int changenum = QSnumlist[left2];
				QSnumlist[left2] = QSnumlist[right2];
				QSnumlist[right2] = changenum;
			}
		}
		
		//【基準値>右側の要素】========================
		if(QSnumlist[left] > QSnumlist[right2]){
			int changenum = QSnumlist[left];
			QSnumlist[left] = QSnumlist[right2];
			QSnumlist[right2] = changenum;
		}
		
		//【再起メソッドの実施】========================
		//基準値より左================================
		if(left < right2-1){
			qSort(QSnumlist,left,right2-1);
		}
		//基準値より右================================
		if(right2+1 < right){
			qSort(QSnumlist,right2+1,right);
		}
	}
}
