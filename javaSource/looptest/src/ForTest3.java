public class ForTest3 {
	public static void main(String[] args) {
		//134p 3번 문제
		int sum = 0;
		for(int i = 3 ; i <= 100 ; i += 3){
			sum += i;
		}
		System.out.println(sum);

		// 5번 문제
		int x = 0;
		int y = 0;
		int result = 0;

		for(x = 1 ; x <= 10 ; x++){
			for(y = 1 ; y <= 10 ; y ++){
				if ( (4*x + 5*y) == 60 ) {
					System.out.println(x + " , " + y);
				}
			}
		}
		// 6번 문제
		x = 0;
		y = 0;
		for( y = 1 ; y <= 5 ; y++){
			for( x= 0 ; x < y ; x++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for(y = 5 ; y > 0 ; y--){
			for(x = 0; x < y ; x++){
			
			}
		}

	}
}
