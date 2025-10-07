package abstractfactory;

public class ArgentinianPizzaIngredientFactory implements PizzaIngredientFactory {
    public ArgentinianPizzaIngredientFactory(){

    }   
    
    public Dough createDough(){
        return new WideDough();
    }

	public Sauce createSauce(){
        return new SalsaArcor();
    }

	public Cheese createCheese(){
        return new MozzarellaCheese();
    }

	public Veggies[] createVeggies(){
        Veggies veggies[] = { new Aceituna(), 
		                      new Onion()};
		return veggies;
    }

	public Pepperoni createPepperoni(){
        return null;
    }

	public Clams createClam(){
        return null;
    }
}
