package game.of.life2;
public class S23 implements Vive{
    //DEBERIA SER CLASE ABSTRACTA PARA LA MANIPULACION DE STEPS Y STATS
    Step step;
    public S23(Step step){
        this.step = step;
    }

    public Celda vive(Celda celda, int numVecinos){
        if(!celda.estado){
            throw new IllegalArgumentException("La casilla pasada debe ser una casilla viva");
        }

        Celda newCelda;
        ColorBehaviour color;
        if(numVecinos == 2 || numVecinos == 3){
            step.incrementarSupervivencias();
            return celda; 
        }else{
            color = new ColBehBasicOFF();
            newCelda = new Celda(false,color);
            step.incrementarMuertes();
            return newCelda;
        }
    }
}
