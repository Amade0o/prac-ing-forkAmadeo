package abstractfactory;

public class ArgentinianPizzaStore extends PizzaStore{
    public ArgentinianPizzaStore(){

    }

    @Override
    protected Pizza createPizza(String item){
        PizzaIngredientFactory ingredientFactory = new ArgentinianPizzaIngredientFactory();
        Pizza pizza = null;

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Arg Style Cheese Pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Arg Style Veggie Pizza");

		} else if (item.equals("clam")) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Arg Style Clam Pizza");

		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Arg Style Pepperoni Pizza");

		}
		return pizza;
    }
}    

