package game.of.life2;
//SOLO FUNCIONA CON FABRICA BASICA
public class NegativeObserver implements Observer{
    Tablero tablero;
    Celda[][] tableroCeldas;
    
    public NegativeObserver(Tablero tablero){
        this.tablero = tablero;
    }

    @Override
    public void print(){
        for (int i = 0; i < tableroCeldas.length; i++) {
            for (int j = 0; j < tableroCeldas[0].length; j++) {
                if(tableroCeldas[i][j].getColor() == '•'){
                    System.out.print("█");
                }else{
                    System.out.print("•");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void update(){
        System.out.println("El tablero dio un step!");
        tableroCeldas = tablero.getTablero();
        print();
    }
}
