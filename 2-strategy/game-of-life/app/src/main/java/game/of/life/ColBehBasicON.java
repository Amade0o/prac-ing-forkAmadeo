package game.of.life;
import game.of.life.ColorBehaviour;

public class ColBehBasicON implements ColorBehaviour{
    public ColBehBasicON(){

    }
    
    @Override
    public char getColor(Celda celda){
        return '█';
    }
}
