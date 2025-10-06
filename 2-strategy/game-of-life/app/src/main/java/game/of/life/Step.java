package game.of.life;

import java.util.ArrayList;
import java.util.List;

public abstract class Step {
    Nace nace;
    Vive vive;

    public abstract Celda[][] doStep(Celda[][] currentGeneration);

    public int calcularVecinos(Celda[][] currentGeneration, int x, int y, int filas, int columnas){
        //[Fil][Col]
        int contVivos = 0; //Contador de cuadrados vivos a los laterales
        

        for (int i = x-1; i <= x+1; i++) {
            for(int j = y-1; j <= y+1; j++){
                if(j == y && i == x){
                    //skip
                }else{
                    if (i >= 0 && i < filas && j >= 0 && j < columnas && currentGeneration[i][j].estado) {
                            contVivos++; //Itera si esta dentro de la matriz y es true
                    }
                }
                //skip
            }
                
        }
        

        return contVivos;
    }

    // en Step.java (sólo el método modificado)
protected List<Celda> obtenerVecinos(Celda[][] currentGeneration, int x, int y, int filas, int columnas){
    List<Celda> lista = new ArrayList<Celda>();
    for (int i = x-1; i <= x+1; i++) {
        for(int j = y-1; j <= y+1; j++){
            if(j == y && i == x){
                //skip
            }else{
                if (i >= 0 && i < filas && j >= 0 && j < columnas && currentGeneration[i][j].estado) {
                    lista.add(currentGeneration[i][j]);
                }
            }
        }
    }
    return lista;   
}

}
