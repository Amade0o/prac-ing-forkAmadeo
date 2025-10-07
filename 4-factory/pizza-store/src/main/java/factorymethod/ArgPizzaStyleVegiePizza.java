package factorymethod;

import java.util.ArrayList;

public class ArgPizzaStyleVegiePizza extends Pizza{
    public ArgPizzaStyleVegiePizza(){
        name = "Pizza vegana Estilo Arg ajjasj";
	    dough = "Masa gordita de harina de avena";
	    sauce = "Salsa de tomate libre de violencia";
	    toppings = new ArrayList<String>();
        toppings.add("Queso de almendra");
        toppings.add("Jamon vegano");
    }
}
