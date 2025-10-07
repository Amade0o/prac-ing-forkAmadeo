package game.of.life2;

public class BasicObserver implements Observer{
    Tablero tablero;
    Celda[][] tableroMatriz;
    int contadorIteraciones;

    public BasicObserver(Tablero tablero){
        this.tablero = tablero;
        contadorIteraciones = 0;
    }

    public void print(){
        for (int i = 0; i < tableroMatriz.length; i++) {
            for (int j = 0; j < tableroMatriz[0].length; j++) {
                System.out.print(tableroMatriz[i][j].getColor());
            }
            System.out.println();
        }
    }

    public void update(){
        contadorIteraciones++;
        
        System.out.println("El tablero dio un step!");
        tableroMatriz = tablero.getTablero();
        print();
    }
}
