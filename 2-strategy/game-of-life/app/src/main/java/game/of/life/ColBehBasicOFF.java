package game.of.life;
import game.of.life.ColorBehaviour;

public class ColBehBasicOFF implements ColorBehaviour{
    public ColBehBasicOFF(){

    }
    
    @Override
    public char getColor(Celda celda){
        return '•';
    }
}
