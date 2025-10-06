package game.of.life2;

import java.util.ArrayList;

public class Tablero implements Subject{
    private boolean[][] patronInicial;
    private Celda[][] tablero;
    private FabricaCeldas fabrica;
    private Step step;
    ArrayList <Observer> observers;


    public Tablero(boolean[][] patronInicial, FabricaCeldas fabrica, Step step){
        observers = new ArrayList<>();

        //las tendré que copiar de otra forma?
        this.patronInicial = patronInicial;
        
        this.fabrica = fabrica;
        this.step = step;
    }   
    
    @Override
    public void notifyObservers(){
        for(Observer o:observers){
            o.update();
        }
    }

    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void doStep(){
        tablero = crearGrilla(patronInicial, fabrica);
        tablero = step.doStep(tablero);

        notifyObservers();
    }

    public Celda[][] getTablero(){
        if(tablero == null){
            throw new IllegalStateException("El tablero no ha sido inicializado. Llama a doStep() primero.");
        }
        return tablero;
    }

    public Step getStep(){
        return step;
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
