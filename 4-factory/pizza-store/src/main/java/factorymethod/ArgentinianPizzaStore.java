package factorymethod;

public class ArgentinianPizzaStore extends PizzaStore{
    
    public ArgentinianPizzaStore(){

    }

    @Override
    Pizza createPizza(String item) {
        Pizza pizza = null;
        if (item.equals("cheese")) {
        	pizza = new ArgPizzaStyleCheesePizza();
        } else if (item.equals("veggie")) {
            pizza = new ArgPizzaStyleVegiePizza();
        } else if (item.equals("clam")) {
            pizza = new ArgPizzaStyleClamPizza();
        } else if (item.equals("pepperoni")) {
        	pizza = new ArgPizzaStylePepPizza();
        }
        return pizza;
	}
}
