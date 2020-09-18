public class ex0{
	public static void main(String[] args){
		int size = 5;
		int row = 1;
		int col = 0;
		while (row <= size){
			while (col < row){
				System.out.print("*");
				col = col + 1;
			}
			row = row + 1;
			col = 0;
			System.out.println();
		}
	}
}
