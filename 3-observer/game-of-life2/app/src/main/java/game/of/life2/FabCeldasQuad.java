package game.of.life2;

public class FabCeldasQuad implements FabricaCeldas{
    public FabCeldasQuad(){

    }

    @Override
    public Celda crearCelda(boolean estado){
        int randomNumInt;
        Celda celda;
        ColorBehaviour color;

        if(!estado){
            color = new ColBehBasicOFF();
        }else{
            randomNumInt = (int)(Math.random() * 4) + 1;
            if(randomNumInt == 1){
                color = new ColInmig1();
            }else if(randomNumInt == 2){
                color = new ColInm2();
                
            }else if(randomNumInt == 3){
                color = new ColInm3();
            }else{
                color = new ColInm4();
            }
        }
        celda = new CeldaBasica(estado,color);
        return celda;
    }
}
