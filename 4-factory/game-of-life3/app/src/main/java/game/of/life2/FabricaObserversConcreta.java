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

        if(type.equals("BASICOBSERVER")){
            o = new BasicObserver(tablero);
        }else if(type.equals("REPORTOBSERVER")){
            o = new ReportObserver(tablero);
        }else if(type.equals("STATSLOGOBSERVER")){
            o = new StatsLogObserver(tablero);
        }else if (type.equals("NEGATIVEOBSERVER")) {
            o = new NegativeObserver(tablero);
        }else{
            throw new IllegalArgumentException("Ese step no existe");
        }

        return o;
    }
}
