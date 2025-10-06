package game.of.life2;

public class Celda {
    public boolean estado;
    public ColorBehaviour colorBehaviour;


    public Celda(boolean estado, ColorBehaviour colorBehaviourInicial){
        this.estado = estado;
        this.colorBehaviour = colorBehaviourInicial;
    }

    public char getColor(){
        return this.colorBehaviour.getColor(this);
    }

    public void setColor(ColorBehaviour newCBeha){
        this.colorBehaviour = newCBeha;
    }
}
