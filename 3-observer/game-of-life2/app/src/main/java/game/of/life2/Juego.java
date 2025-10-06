package game.of.life2;

public class Juego {

    public static void main(String[] args) {
        // Usaremos este patrón booleano como base para todas las simulaciones.
        boolean[][] patronInicial = {
            {true, true, false, false, false},
            {false, false, true,  true,  false},
            {false, true,  true,  false, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
        };
        
        //1 --- Basic observer ---
        FabricaCeldas fabrica = new FabricaCeldasBasica();
        Step step = new B3S23();
         
        Tablero tableroBasico = new Tablero(patronInicial, fabrica, step);
        Observer observadorTablero = new BasicObserver(tableroBasico); 
        tableroBasico.addObserver(observadorTablero);

        tableroBasico.doStep();
        
        //2 --- Basic observer con celdas quad ---
        fabrica = new FabCeldasQuad();
        step = new QuadB3S23();
        Tablero tableroQuad = new Tablero(patronInicial, fabrica, step);
        observadorTablero = new BasicObserver(tableroQuad);
        tableroQuad.addObserver(observadorTablero); 

        tableroQuad.doStep();

        //3 --- Negative observer ---
        FabricaCeldas fabrica2 = new FabricaCeldasBasica();
        Step step2 = new B3S23();
         
        Tablero tableroBasico2 = new Tablero(patronInicial, fabrica2, step2);
        Observer observadorTablero2 = new NegativeObserver(tableroBasico2); 
        tableroBasico2.addObserver(observadorTablero2);

        tableroBasico2.doStep(); 

        //4 --- Report observer ---
        FabricaCeldas fabrica4 = new FabricaCeldasBasica();
        Step step4 = new B3S23();
        
        Tablero tableroBasico4 = new Tablero(patronInicial, fabrica4, step4);
        Observer observadorTablero4 = new ReportObserver(tableroBasico4); 
        tableroBasico4.addObserver(observadorTablero4);

        tableroBasico4.doStep();

        //5 --- Stats log observer ---
        FabricaCeldas fabrica3 = new FabricaCeldasBasica();
        Step step3 = new B3S23();
         
        Tablero tableroBasico3 = new Tablero(patronInicial, fabrica3, step3);
        StatsLogObserver observadorTablero3 = new StatsLogObserver(tableroBasico3); 
        tableroBasico3.addObserver(observadorTablero3);


        tableroBasico3.doStep();
        observadorTablero3.reportarPromedio();// stats log observer reportes finales
        


    }   
}