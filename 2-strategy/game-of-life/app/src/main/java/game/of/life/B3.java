package game.of.life;

import java.util.List;

public class B3 extends Nace{
    public B3(){

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
        }else{
            color = new ColBehBasicOFF();
            newCelda = new Celda(false,color);            
        }

        return newCelda;
    }    
}