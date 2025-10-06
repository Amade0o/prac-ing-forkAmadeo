package game.of.life;

public class FabricaCeldasBasica implements FabricaCeldas {
    public FabricaCeldasBasica(){

    }   

    @Override
    public Celda crearCelda(boolean estado){
        boolean estadoPrivado = estado;
        Celda celda;
        ColorBehaviour colorBehaviour;
        
        if(estadoPrivado){
            colorBehaviour = new ColBehBasicON();
            celda = new Celda(estadoPrivado,colorBehaviour);
            return celda;
        }else{
            colorBehaviour = new ColBehBasicOFF();
            celda = new Celda(estadoPrivado,colorBehaviour);
            return celda;
        }
    }
}
