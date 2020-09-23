class OuterClass1{
	int x = 10;
	// nested class
	static class InnerClass{
		int y = 5;
	}
}

class OuterClass2{
	int x = 10;
	// nested class
	class InnerClass{
		int y = 5;
		public int myInnerMethod(){
			return x;
		}
	}
}


public class TestOfClass {
	public static void main(String[] args){
		// no need to create an object of the outer class when the inner class
		// is static.
		OuterClass1.InnerClass myInner1 = new OuterClass1.InnerClass();
		System.out.println(myInner1.y);
		
		// access the outer class from the inner class
		OuterClass2 myOuter = new OuterClass2();
		OuterClass2.InnerClass myInner2 = myOuter.new InnerClass();
		System.out.println(myInner2.myInnerMethod());
	}
}
