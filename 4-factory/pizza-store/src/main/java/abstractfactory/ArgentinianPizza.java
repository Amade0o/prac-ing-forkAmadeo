package abstractfactory;

public class ArgentinianPizza extends Pizza{
    /*
     * String name;

	    Dough dough;
	    Sauce sauce;
	    Veggies veggies[];
	    Cheese cheese;
	    Pepperoni pepperoni;
	    Clams clam;
     */
    PizzaIngredientFactory ingredientFactory;
    public ArgentinianPizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = new ArgentinianPizzaIngredientFactory();
    }

    @Override
    public void prepare(){
        System.out.println("Preparando "+ name);
        name = "Pizza argentina!";
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        veggies = ingredientFactory.createVeggies();
        cheese = ingredientFactory.createCheese();
        pepperoni = ingredientFactory.createPepperoni();
        clam = ingredientFactory.createClam();
    }
}
