package game.of.life2;

import java.util.List;

public class B3 extends Nace{
    public B3(Step step){
        super(step);
    }

    @Override
    public Celda nace(Celda casilla, int numVecinos,List<Celda> listaVecinos){
        if(casilla.estado){
            throw new IllegalArgumentException("La casilla pasada por parametro debe ser false");
        }
        Celda newCelda;
        ColorBehaviour color;

        if(numVecinos == 3){
            //ColorBehaviour para basico "ON"
            color = new ColBehBasicON();
            newCelda = new Celda(true,color);
            step.incrementarNacimientos();
        }else{
            color = new ColBehBasicOFF();
            newCelda = new Celda(false,color);
            step.incrementarMuertes();            
        }

        return newCelda;
    }    
}