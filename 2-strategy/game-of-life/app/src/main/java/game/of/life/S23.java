package game.of.life;
public class S23 implements Vive{
    public S23(){

    }

    public Celda vive(Celda celda, int numVecinos){
        if(!celda.estado){
            throw new IllegalArgumentException("La casilla pasada debe ser una casilla viva");
        }

        Celda newCelda;
        ColorBehaviour color;
        if(numVecinos == 2 || numVecinos == 3){
            return celda; 
        }else{
            color = new ColBehBasicOFF();
            newCelda = new Celda(false,color);
            return newCelda;
        }
    }
}
