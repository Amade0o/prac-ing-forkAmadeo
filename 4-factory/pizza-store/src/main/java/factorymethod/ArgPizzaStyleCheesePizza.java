package factorymethod;

import java.util.ArrayList;

public class ArgPizzaStyleCheesePizza extends Pizza{
    public ArgPizzaStyleCheesePizza(){
        name = "Pizza queso Estilo Arg ajjasj";
	    dough = "Masa muy gorda";
	    sauce = "Salsa de tomate mal triturado";
	    toppings = new ArrayList<String>();
        toppings.add("Queso barato");
        toppings.add("Mas queso barato");
    }    
}
