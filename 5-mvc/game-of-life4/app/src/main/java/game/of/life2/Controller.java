package game.of.life2;

public class Controller { 
    private Tablero tablero;  
    private Step step;
    private Observer observer;
    private boolean[][] patronInicialAux;
    
    FabricaSteps fabricaSteps;
    FabricaObservers fabricaObservers;
    FabricaCeldas fabricaCeldas;

    public Controller(boolean[][] patronInicialAux){
        this.patronInicialAux = patronInicialAux;
        this.fabricaSteps = new FabricaStepsConcreta();
        this.fabricaObservers = new FabricaObserversConcreta();
    }   

    public void seleccionarStep(String type){
        step = fabricaSteps.createStep(type);
    }

    public void seleccionarObserver(String type){
        tablero = new Tablero(patronInicialAux,fabricaCeldas,step);
        observer = fabricaObservers.createObserver(type, tablero);
    }

    public void darStep(){
        tablero.addObserver(observer);
        tablero.doStep();
    }

    public void seleccionarCelda(String celda){
        celda = celda.toUpperCase();
        if(celda == null){
            throw new IllegalArgumentException("Ese step no existe");
        }else switch (celda) {
            case "QUAD":
                fabricaCeldas = new FabCeldasQuad();
                break;
            case "BASICA":
                fabricaCeldas = new FabricaCeldasBasica();
                break;
            case "INMIGRATION":
                fabricaCeldas = new FabricaCeldasInmigration();
                break;
            default:
                throw new IllegalArgumentException("Ese step no existe");
        }
    }
}
