package game.of.life2;

import java.util.ArrayList;
import java.util.List;

public class B3S23 extends Step{
    public B3S23(){
        nace = new B3(this);
        vive = new S23(this);

        this.nacimientosTotales = 0;
        this.muertesTotales = 0;
        this.supervivenciasTotales = 0;
    }

    @Override
    public Celda[][] doStep(Celda[][] currentGeneration){
        int filas = currentGeneration.length;
        int columnas = currentGeneration[0].length;


        Celda[][] newGeneration = new Celda[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++){
                calculador(currentGeneration,i,j,filas,columnas,newGeneration);
            }
        }

        return newGeneration;
    }

    private void calculador(Celda[][] currentGeneration, int x, int y, int filas, int columnas, Celda[][] newGeneration){
        Celda casilla = currentGeneration[x][y];
        int numVecinos = calcularVecinos(currentGeneration,x,y,filas,columnas);
        List<Celda> listaVecinos = new ArrayList<>();

        if(casilla.estado){
            newGeneration[x][y] = vive.vive(casilla, numVecinos);
        }else {
            newGeneration[x][y] =  nace.nace(casilla, numVecinos,listaVecinos);
        }
    }
    //Notas:
    //nace.nace(Boolean casilla, int numVecinos)
    //vive.vive(Boolean casilla, int numVecinos)
}
