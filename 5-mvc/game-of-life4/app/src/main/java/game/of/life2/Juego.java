package game.of.life2;

public class Juego {

    public static void main(String[] args) {
        //Creo una nueva view
        View view = new View();
        while (view.showView()) {
        // el ciclo se repite hasta que el usuario diga "n"
        }
    }
    





























    private void Borrado(){
            // Usaremos este patrón booleano como base para todas las simulaciones.
        boolean[][] patronInicial = {
            {true, true, false, false, false},
            {false, false, true,  true,  false},
            {false, true,  true,  false, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
        };
        FabricaSteps fabricaSteps = new FabricaStepsConcreta();
        FabricaObservers fabricaObservers = new FabricaObserversConcreta();

        //1 --- Basic observer ---
        FabricaCeldas fabrica = new FabricaCeldasBasica();
        Step step = fabricaSteps.createStep("B3S23");
         
        Tablero tableroBasico = new Tablero(patronInicial, fabrica, step);
        Observer observadorTablero = fabricaObservers.createObserver("BASICOBSERVER", tableroBasico); 
        tableroBasico.addObserver(observadorTablero);

        tableroBasico.doStep();
        
        //2 --- Basic observer con celdas quad ---
        fabrica = new FabCeldasQuad();
        step = fabricaSteps.createStep("QuadB3S23");

        Tablero tableroQuad = new Tablero(patronInicial, fabrica, step);
        observadorTablero = fabricaObservers.createObserver("BASICOBSERVER", tableroQuad); 
        tableroQuad.addObserver(observadorTablero); 

        tableroQuad.doStep();

        //3 --- Negative observer ---
        FabricaCeldas fabrica2 = new FabricaCeldasBasica();
        Step step2 = fabricaSteps.createStep("B3S23");

        Tablero tableroBasico2 = new Tablero(patronInicial, fabrica2, step2);
        Observer observadorTablero2 = fabricaObservers.createObserver("NEGATIVEOBSERVER", tableroBasico2); 
        tableroBasico2.addObserver(observadorTablero2);

        tableroBasico2.doStep(); 

        //4 --- Report observer ---
        FabricaCeldas fabrica4 = new FabricaCeldasBasica();
        Step step4 = fabricaSteps.createStep("B3S23");
        
        Tablero tableroBasico4 = new Tablero(patronInicial, fabrica4, step4);
        Observer observadorTablero4 = fabricaObservers.createObserver("REPORTOBSERVER", tableroBasico4); 
        tableroBasico4.addObserver(observadorTablero4);

        tableroBasico4.doStep();

        //5 --- Stats log observer ---
        FabricaCeldas fabrica3 = new FabricaCeldasBasica();
        Step step3 = fabricaSteps.createStep("B3S23");
         
        Tablero tableroBasico3 = new Tablero(patronInicial, fabrica3, step3);
        StatsLogObserver observadorTablero3 = (StatsLogObserver) fabricaObservers.createObserver("STATSLOGOBSERVER", tableroBasico3); 
        tableroBasico3.addObserver(observadorTablero3);


        tableroBasico3.doStep();
        observadorTablero3.reportarPromedio();// stats log observer reportes finales
    }
}