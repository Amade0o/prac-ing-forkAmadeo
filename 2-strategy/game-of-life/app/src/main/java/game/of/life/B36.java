package game.of.life;

import java.util.List;

public class B36 extends Nace{
    public B36(){
        //nada
    }

    @Override
    public Celda nace(Celda celda, int numVecinos,List<Celda> listaVecinos){
        //No se hace nada con listaVecinos
        if(celda.estado){
            throw new IllegalArgumentException("La casilla pasada por parametro debe ser false");
        }
        Celda newCelda;

        if(numVecinos == 3 || numVecinos == 6){
            //ColorBehaviour para basico "ON"
            ColorBehaviour color = new ColBehBasicON();
            newCelda = new Celda(true,color);
        }else{
            //ColorBehaviour para basico "ON"
            ColorBehaviour color = new ColBehBasicOFF();
            newCelda = new Celda(false, color);
        }
        return newCelda;
    }    
}
