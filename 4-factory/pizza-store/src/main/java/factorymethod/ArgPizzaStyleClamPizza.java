package factorymethod;

import java.util.ArrayList;

public class ArgPizzaStyleClamPizza extends Pizza{
    public ArgPizzaStyleClamPizza(){
        name = "Pizza De Almeja(? Estilo Arg";
	    dough = "Masa gordita";
	    sauce = "Salsa golf y tomate";
	    toppings = new ArrayList<String>();
        toppings.add("Almeja jasdad");
        toppings.add("Queso cremoso");
        toppings.add("Palmito");
    }
}
