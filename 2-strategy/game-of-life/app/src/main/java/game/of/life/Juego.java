package game.of.life;

public class Juego {

    public static void main(String[] args) {
        
        // --- 1. CONFIGURACIÓN INICIAL COMÚN ---
        
        // Usaremos este patrón booleano como base para todas las simulaciones.
        boolean[][] patronInicial = {
            {false, false, false, false, false},
            {false, false, true,  true,  false},
            {false, true,  true,  false, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
        };

        // Instanciamos un único display que reutilizaremos para todo.
        Display display = new DisplayBasico();

        
        // =================================================================
        // ==     PRUEBA 1: REGLAS BÁSICAS (Conway's Game of Life)        ==
        // =================================================================
        System.out.println("--- Probando Reglas Básicas (B3/S23) ---");
        
        // Para las reglas básicas, solo necesitamos una fábrica simple.
        // Asumo que tienes una, si no, puedes crear una FabricaCeldasBasica.
        FabricaCeldas fabricaBasica = new FabricaCeldasBasica(); 
        Celda[][] matrizBasica = crearGrilla(patronInicial, fabricaBasica);
        
        Step stepConway = new B3S23(); // El Juego de la Vida Clásico
        Celda[][] resultadoConway = stepConway.doStep(matrizBasica);

        System.out.println("Matriz inicial (Básica):");
        display.display(matrizBasica);
        System.out.println("\nSiguiente generación (B3/S23):");
        display.display(resultadoConway);


        // =================================================================
        // ==            PRUEBA 2: INMIGRATION GAME                         ==
        // =================================================================
        System.out.println("\n\n--- Probando Inmigration (B3/S23) ---");

        // Usamos la fábrica específica de Inmigration.
        FabricaCeldas fabricaInmigracion = new FabricaCeldasInmigration();
        Celda[][] matrizInmigracion = crearGrilla(patronInicial, fabricaInmigracion);
        
        Step stepInmigracion = new InmigrationB3S23();
        Celda[][] resultadoInmigracion = stepInmigracion.doStep(matrizInmigracion);

        System.out.println("Matriz inicial (Inmigration):");
        display.display(matrizInmigracion);
        System.out.println("\nSiguiente generación (Inmigration):");
        display.display(resultadoInmigracion);

        
        // =================================================================
        // ==              PRUEBA 3: QUADLIFE GAME                        ==
        // =================================================================
        System.out.println("\n\n--- Probando QuadLife (B3/S23) ---");

        // Usamos la fábrica específica de QuadLife que creamos.
        FabricaCeldas fabricaQuad = new FabCeldasQuad();
        Celda[][] matrizQuad = crearGrilla(patronInicial, fabricaQuad);
        
        Step stepQuad = new QuadB3S23();
        Celda[][] resultadoQuad = stepQuad.doStep(matrizQuad);

        System.out.println("Matriz inicial (QuadLife con colores al azar):");
        display.display(matrizQuad);
        System.out.println("\nSiguiente generación (QuadLife):");
        display.display(resultadoQuad);
    }

    /**
     * Método auxiliar para crear una grilla de Celdas a partir de un patrón
     * booleano y una fábrica específica. Esto evita repetir código.
     * @param patron La matriz de booleanos con el estado inicial.
     * @param fabrica La fábrica que creará las celdas.
     * @return Una grilla de Celda[][].
     */
    private static Celda[][] crearGrilla(boolean[][] patron, FabricaCeldas fabrica) {
        int filas = patron.length;
        int columnas = patron[0].length;
        Celda[][] nuevaGrilla = new Celda[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevaGrilla[i][j] = fabrica.crearCelda(patron[i][j]);
            }
        }
        return nuevaGrilla;
    }
}