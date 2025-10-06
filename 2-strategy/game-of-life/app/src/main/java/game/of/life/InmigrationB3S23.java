package game.of.life;

import java.util.ArrayList;
import java.util.List;

public class InmigrationB3S23 extends Step{
    public InmigrationB3S23(){
        nace = new InmigrationB3();
        vive = new S23();
    }

    @Override
    public Celda[][] doStep(Celda[][] currentGeneration){
        int filas = currentGeneration.length;
        int columnas = currentGeneration[0].length;

        Celda[][] nextGeneration = new Celda[filas][columnas];
        int nVecinos = 0;
        List<Celda> listaVecinos = new ArrayList<>();

        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                // en InmigrationB3S23.java, dentro de doStep, en el for:
                nVecinos = calcularVecinos(currentGeneration, i, j, filas, columnas);

                // obtener lista real
                listaVecinos = obtenerVecinos(currentGeneration, i, j, filas, columnas);

                if(currentGeneration[i][j].estado){
                    nextGeneration[i][j] = vive.vive(currentGeneration[i][j], nVecinos);
                }else{
                    nextGeneration[i][j] = nace.nace(currentGeneration[i][j], nVecinos, listaVecinos);
                }

            }
        }

        return nextGeneration;
    }
}
