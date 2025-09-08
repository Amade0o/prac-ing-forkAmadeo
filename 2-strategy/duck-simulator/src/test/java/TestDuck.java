import org.junit.jupiter.api.Test;

public class TestDuck {

    @Test
    public void testMallardDuck() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }

    @Test
    public void testModelDuck() {
        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();
    }

    @Test
    public void testModelDuckChangeFlyBehavior() {
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }

    @Test
    public void testModelDuckChangeQuackBehavior() {
        Duck model = new ModelDuck();
        model.performQuack();
        model.setQuackBehavior(new QuackDolor());
        model.performFly();
    }

    @Test
    public void testPatoCagonQuackDolor(){
        Duck model = new DuckCagon();
        model.performQuack();
        model.performFly();
    }

    @Test
    public void testPatoHelicoptero(){
        Duck heli = new PatoHelice();
        heli.performFly();
        heli.performFly();
    }

    @Test 
    public void testDuckFlock(){
        DucksFlock flock = new DucksFlock();
        flock.cuackBandada();
        flock.flyBandada();
    }

    @Test
    public void testDuckFlockMono(){
        DucksFlockMono flockMono = new DucksFlockMono();
        flockMono.cuackBandada();
        flockMono.flyBandada();
    }
}
