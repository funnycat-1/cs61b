public class continueToNextLoop{
	public static void main(String[] args){
		int count = 0;
		int[] values = {10, 8, 29, 93};
		for(int i = 0; i < values.length; i++){
			if (values[i] != 0)
				continue;
			count++;
		}
		System.out.println("The number of 0s in values arrays: " + count);
	}
}