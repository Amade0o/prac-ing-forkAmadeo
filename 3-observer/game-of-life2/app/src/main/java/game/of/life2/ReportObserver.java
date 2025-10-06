package game.of.life2;

public class ReportObserver implements Observer {
    Celda[][] tableroMatriz;
    Tablero tablero;


    
    public ReportObserver(Tablero tablero){
        this.tablero = tablero;
    }

    @Override
    public void print(){
        for (int i = 0; i < tableroMatriz.length; i++) {
            for (int j = 0; j < tableroMatriz[0].length; j++) {
                // Usamos el método getColor() que ya tenías
                System.out.print(tableroMatriz[i][j].getColor() + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    @Override
    public void update(){
        System.out.println("El tablero dio un step!");
        tableroMatriz = tablero.getTablero();
        print();
    }
}
