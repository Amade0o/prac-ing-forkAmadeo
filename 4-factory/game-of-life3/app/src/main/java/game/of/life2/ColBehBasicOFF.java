package game.of.life2;

public class ColBehBasicOFF implements ColorBehaviour{
    public ColBehBasicOFF(){

    }
    
    @Override
    public char getColor(Celda celda){
        return '•';
    }
}
