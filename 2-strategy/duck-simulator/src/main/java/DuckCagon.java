public class DuckCagon extends Duck{
    public DuckCagon() {
        quackBehavior = new QuackDolor();
        flyBehavior = new FlyWithWings();
    }

    public void display(){
        System.out.println("Soy un pato cagon");
    }
}