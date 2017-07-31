package algorithm.typeA;

import java.util.Scanner;

public class Traiangle {
	
	public static void main(String args[]){
		Scanner stdIn = new Scanner(System.in);
		
		int base = 0;
		int height = 0;
		int area = 0;
		
		String[] text = new String[3];
		text[0] = "底面：";
		text[1] = "高さ：";
		text[2] = "面積：";
		
		for(int i=0; i<2 ; ++i){
			if(i == 0){
				System.out.print(text[i]);
				String base2 = stdIn.next(); 
				base = Integer.parseInt(base2);
			}else{
				System.out.print(text[i]);
				String height2 = stdIn.next(); 
				height = Integer.parseInt(height2);
			}		
		};
		
		area = (base * height)/2;
		System.out.println(text[2] + area + "です。");
	}
	
}
