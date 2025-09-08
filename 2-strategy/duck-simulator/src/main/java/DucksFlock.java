import java.util.ArrayList;
import java.util.List;

public class DucksFlock{
    private List<Duck> bandada;
    public DucksFlock(){
        bandada = new ArrayList<>();
        cargarBandada();
    }

    private void cargarBandada(){
        Duck patoHelice = new PatoHelice();
        Duck modelDuck = new ModelDuck();
        Duck mallardDuck = new MallardDuck();
        Duck patoCriollo = new PatoCriollo();
        Duck patoMaricon = new DuckCagon();

        bandada.add(patoHelice);
        bandada.add(modelDuck);
        bandada.add(mallardDuck);
        bandada.add(patoCriollo);
        bandada.add(patoMaricon); 
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
        bandada.add(duck);
    }
}