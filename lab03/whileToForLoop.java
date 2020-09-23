public class whileToForLoop{
	public static void main(String[] args){
		int k = 0;
		while (k < 10){
			System.out.println(k);
			k++;
		}

		for (int i = 0; i < 10; i++){
			System.out.println(i);
		}

		int j = 0;
		while (j < 10){
			j++;
			System.out.println(j);
		}

		for (int i = 1; i <= 10; i++){
			System.out.println(i);
		}
	}
}