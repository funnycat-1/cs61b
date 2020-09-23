public class recognizingPurpose{
	private static int  findStrictlyIncreasedMax(int[] values) {
		int rtn = values[0];
		int k = 1;
		while(k < values.length){
			if(rtn < values[k])
				rtn = values[k];
			k++;
		}
		return rtn;
	}

	private static void swap(int[] values){
		int k = 0;
		while(k < values.length / 2){
			int temp = values[k];
			values[k] = values[values.length - 1 - k];
			values[values.length - 1 - k] = temp;
			k++;
		}
	}

	private static boolean isStrictlyIncrease(int[] values){
		int k = 0;
		while(k < values.length - 1){
			if (values[k] > values[k+1])
				return false;
			k++; 
		}
		return true;
	}

	private static int findNumbersOfTarget(int[] values, int a){
		int k = 0;
		int n = 0;
		while(k < values.length){
			if (values[k] == a){
				n++;
			}
			k++;
		}
		return n;
	}

	public static void main(String[] args){

	}
}