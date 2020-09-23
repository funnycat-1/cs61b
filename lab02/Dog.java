public class Dog{
	public int weightInPounds;
	public String name;

	public void setWeight(int weightInPounds){
		weightInPounds = weightInPounds;
	}

	public void makeNoise(){
		if(weightInPounds < 10){
			System.out.println("yipyipyip!");
		} else if (weightInPounds < 30){
			System.out.println("bark. bark");
		} else {
			System.out.println("woof");
		}
	}

	public static void main(String[] args){
		Dog myDog;
		myDog = new Dog();
		myDog.setWeight(20);
		System.out.println(myDog.weightInPounds);
	}
}
