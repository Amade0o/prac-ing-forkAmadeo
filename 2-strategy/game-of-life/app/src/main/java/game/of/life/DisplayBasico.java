package game.of.life;
public class DisplayBasico implements Display{
    public DisplayBasico(){

    }

    @Override
    public void display(Celda[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j].getColor());
            }
            System.out.println();
        }
    }
}
