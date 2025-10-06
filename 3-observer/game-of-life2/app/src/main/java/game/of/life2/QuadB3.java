package game.of.life2;

import java.util.List;

public class QuadB3 extends Nace{
    private final ColorSelectionStrategy strategy;

    public QuadB3(Step step){
        super(step);
        this.strategy = new QuadColorSelection();
    }

    @Override
    public Celda nace(Celda casilla, int numVecinos, List<Celda> listaVecinos){
        if(casilla.estado){
            throw new IllegalArgumentException("La casilla pasada por parametro debe ser false");
        }
        Celda newCelda;
        ColorBehaviour color;

        if(numVecinos == 3){
            color = strategy.selectColor(listaVecinos);
            newCelda = new Celda(true,color);
            return newCelda;
        }else{
            return new Celda(false, new ColBehBasicOFF());
        }
    }
}
