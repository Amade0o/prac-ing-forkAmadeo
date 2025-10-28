package game.of.life2;

import java.util.NoSuchElementException;

/**
 * Los inputs validos son (mayusculas-minusculas-ambos):
 * B3S23-B36S23-INMB3S23-QUADB3S23
 */
public class FabricaStepsConcreta implements FabricaSteps{
    public FabricaStepsConcreta(){

    }

    @Override
    public Step createStep(String type){
        if(type.equals("")){
            throw new NoSuchElementException("Tenes que especificar el tipo");
        }
        type = type.toUpperCase();
        
        Step step;

        switch (type) {
            case "B3S23":
                step = new B3S23();
                break;
            case "B36S23":
                step = new B36S23();
                break;
            case "INMB3S23":
                step = new InmigrationB3S23();
                break;
            case "QUADB3S23":
                step = new QuadB3S23();
                break;
            default:
                throw new IllegalArgumentException("Ese step no existe");
        }

        return step;
    }
}
