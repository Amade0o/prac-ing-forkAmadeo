// FabricaCeldasInmigracion.java (NUEVA CLASE)
package game.of.life2;

public class FabricaCeldasInmigration implements FabricaCeldas {

    public FabricaCeldasInmigration() {
   
    }
    
    // Sobrecargamos el método para mantener la compatibilidad si no se pasa la posición
    @Override
    public Celda crearCelda(boolean estado) {
        boolean estadoPrivado = estado;
        Celda celda;
        ColorBehaviour colorBehaviour;
        
        if(estadoPrivado){
            //seleccion de numero aleatorio entre 1 y 3
            int randomNum = (int)(Math.random() * 3) + 1;
            if(randomNum == 1){
                colorBehaviour = new ColInmig1();
            }else if(randomNum == 2){
                colorBehaviour = new ColInm2();
            }else{
                colorBehaviour = new ColInm3();
            }

            celda = new Celda(estadoPrivado,colorBehaviour);
            return celda;
        }else{
            colorBehaviour = new ColBehBasicOFF();
            celda = new Celda(estadoPrivado,colorBehaviour);
            return celda;
        }
    }
}