package game.of.life2
;

public class ColBehBasicON implements ColorBehaviour{
    public ColBehBasicON(){

    }
    
    @Override
    public char getColor(Celda celda){
        return '█';
    }
}
