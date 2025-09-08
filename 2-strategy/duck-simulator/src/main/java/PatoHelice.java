public class PatoHelice extends Duck{
    public PatoHelice(){
        flyBehavior = new HeliceFly();
	    quackBehavior = new Quack();
    }

    public void display(){
        System.out.println("Soy un pato elice!");
    }
}