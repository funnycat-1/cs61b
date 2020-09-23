public class breakingFromLoops{
	public static void main(String[] args){
		boolean found = false;
		int[] values = {1, 2, 3, 4, 100};
		int value = 50;
		for(int k = 0; k < values.length; k++){
			if(values[k] == value){
				found = true;
				break;
			}
		}
		if(found)
			System.out.println("Found");
		else
			System.out.println("Not found");
	}
}