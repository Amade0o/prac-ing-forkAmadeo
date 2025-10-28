package game.of.life2;

import java.util.NoSuchElementException;

public class FabricaObserversConcreta implements FabricaObservers{
    public FabricaObserversConcreta(){

    }

    public Observer createObserver(String type, Tablero tablero){
        if(type.equals("")){
            throw new NoSuchElementException("Tenes que especificar el tipo");
        }
        type = type.toUpperCase();
        
        Observer o = null;

        switch (type) {
            case "BASICOBSERVER":
                o = new BasicObserver(tablero);
                break;
            case "REPORTOBSERVER":
                o = new ReportObserver(tablero);
                break;
            case "STATSLOGOBSERVER":
                o = new StatsLogObserver(tablero);
                break;
            case "NEGATIVEOBSERVER":
                o = new NegativeObserver(tablero);
                break;
            default:
                throw new IllegalArgumentException("Ese step no existe");
        }

        return o;
    }
}
