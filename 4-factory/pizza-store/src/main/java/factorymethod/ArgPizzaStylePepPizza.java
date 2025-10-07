package factorymethod;

import java.util.ArrayList;

public class ArgPizzaStylePepPizza extends Pizza{
    public ArgPizzaStylePepPizza(){
        name = "Pizza De Peperoni Estilo Arg";
	    dough = "Masa gordita";
	    sauce = "Salsa Cajita Arcor";
	    toppings = new ArrayList<String>();
        toppings.add("Chorizo");
        toppings.add("Queso cremoso");
        toppings.add("Oregano");
    }
}
