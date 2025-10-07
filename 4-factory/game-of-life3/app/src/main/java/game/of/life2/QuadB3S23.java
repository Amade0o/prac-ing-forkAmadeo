package game.of.life2;

import java.util.List;

public class QuadB3S23 extends Step {

    /**
     * Constructor de la clase de paso para QuadLife.
     * Aquí es donde conectamos las reglas específicas que definimos antes.
     */
    public QuadB3S23() {
        // Asignamos la regla de nacimiento que creamos para QuadLife.
        this.nace = new QuadB3(this);
        
        // Asignamos una regla de supervivencia. Usaremos la estándar S23,
        // que es la más común en el Juego de la Vida.
        this.vive = new S23(this); 
    }

    /**
     * Calcula el estado de la siguiente generación para toda la grilla.
     * @param currentGeneration La grilla actual del juego.
     * @return Una nueva grilla con el estado de la siguiente generación.
     */
    @Override
    public Celda[][] doStep(Celda[][] currentGeneration) {
        int filas = currentGeneration.length;
        int columnas = currentGeneration[0].length;

        // Creamos una nueva grilla para no modificar la actual mientras la leemos.
        Celda[][] nextGeneration = new Celda[filas][columnas];

        // Recorremos cada celda de la grilla actual.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                
                // Para cada celda, obtenemos su número de vecinos y la lista de vecinos.
                int nVecinos = calcularVecinos(currentGeneration, i, j, filas, columnas);
                List<Celda> listaVecinos = obtenerVecinos(currentGeneration, i, j, filas, columnas);

                // Decidimos qué regla aplicar basándonos en si la celda está viva o muerta.
                if (currentGeneration[i][j].estado) {
                    // Si la celda está VIVA, aplicamos la regla de supervivencia.
                    nextGeneration[i][j] = this.vive.vive(currentGeneration[i][j], nVecinos);
                } else {
                    // Si la celda está MUERTA, aplicamos la regla de nacimiento.
                    nextGeneration[i][j] = this.nace.nace(currentGeneration[i][j], nVecinos, listaVecinos);
                }
            }
        }

        // Devolvemos la grilla de la nueva generación ya calculada.
        return nextGeneration;
    }
}