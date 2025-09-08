import java.util.ArrayList;
import java.util.List;

public class DucksFlockMono {
    private List<Duck> bandada;
    public DucksFlockMono() {
        bandada = new ArrayList<>();
        cargarBandada();
    }

    private void cargarBandada(){
        Duck patoHelice1 = new PatoHelice();
        Duck patoHelice2 = new PatoHelice();
        Duck patoHelice3 = new PatoHelice();

        bandada.add(patoHelice1);
        bandada.add(patoHelice2);
        bandada.add(patoHelice3);
    }

    public void cuackBandada(){
        for(Duck duck : bandada){
            System.out.println("");
            duck.performQuack();
        }
    }

    public void flyBandada(){
        for(Duck duck : bandada){
            System.out.println("");
            duck.performFly();
        }  
    }

    // Opcional: método para agregar patos desde fuera
    public void addDuck(Duck duck) {
        if(duck instanceof PatoHelice) {
            bandada.add(duck);
        } else {
            System.out.println("Solo se pueden agregar patos de tipo PatoHelice a esta bandada.");
        }
    }
}
