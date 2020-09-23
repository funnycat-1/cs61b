public class Potato {
    /** An instance variable representing the potato's species. */
    private String variety;
    /** An instance variable representing the potato's age. */
    private int age;
    
    /** Default constructor. */
    public Potato(){
        this.variety = "Russet Burbank";
        this.age = 0;
    }
    
    /** A constructor that specify the variety and age. */
    public Potato(String variety, int age){
        this.variety = variety;
        this.age = age;
    }
    
    /** A getter method that gets variety. */
    public String getVariety(){
        return this.variety;
    }
    
    /** A getter method that gets age. */
    public int getAge(){
        return this.age;
    }
    
    /** A setter method that sets the age. */
    public void setAge(int age){
        this.age = age;
    }
    
    /** A method that grows the potato, increase its age by 1. */
    public void grow(){
        System.out.println("Photosynthesis!");
        this.age += 1;
    }
    
    /** Did you know potatoes can flower? Yes, they can. */
    public void flower(){
        System.out.println("I am now flowering!");
    }
    public static void main(String[] args) {
        Potato danielsPotato = new Potato("Yukon Gold", 3);
        System.out.println(danielsPotato.variety);
        System.out.println(danielsPotato.age);
    }
}