package game.of.life;

import java.util.List;

public class InmigrationB3 extends Nace{
    private final ColorSelectionStrategy strategy;

    public InmigrationB3(){
        this.strategy = new MajorityColorStrategy();
    }

    @Override
    public Celda nace(Celda casilla, int numVecinos,List<Celda> listaVecinos){
        if(casilla.estado){
            throw new IllegalArgumentException("La casilla pasada por parametro debe ser false");
        }
        Celda newCelda;
        ColorBehaviour color;
        
        //obtener color mayoritario
        color = strategy.selectColor(listaVecinos);


        if(numVecinos == 3){
            newCelda = new Celda(true,color);
        }else{
            color = new ColBehBasicOFF();
            newCelda = new Celda(false,color);            
        }

        return newCelda;    
    }
}
