import java.util.ArrayList;


/*El problema a resolver era otro!!!!
 Tenia que dar los primeros n numeros primos, no los numeros primos hasta n!!! */
public class NumPrim2 implements interfazComportamiento{
    public NumPrim2(){

    }

    @Override
    public ArrayList<Integer> generarListaPrimos(int n){
        // Maneja el caso de n <= 0
        if (n <= 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> lista = new ArrayList<>();
        int limiteBusqueda = 100;
        
        while(lista.size() < n){
            //Inicializacion
            Boolean[] arreglo = new Boolean[limiteBusqueda+1];

            for(int i = 0; i <= limiteBusqueda; i++){
                arreglo[i] = true;
            }
            arreglo[0] = false;
            arreglo[1] = false;

            //Logica principal de la criba
            for(int i = 2; i*i <= limiteBusqueda; i++){
                if(arreglo[i]){
                    for (int j= i*i; j <= limiteBusqueda; j += i) {
                        arreglo[j] = false;
                    }
                }
            }

            for(int i = 2; i <= limiteBusqueda; i++){
                if(arreglo[i]){
                    lista.add(i);
                }
            }

            // Si no hemos encontrado suficientes, duplicamos el límite
            if (lista.size() < n) {
                limiteBusqueda *= 2;
            }
        }

        ArrayList<Integer> listaFinal = new ArrayList<>();
        for(int i = 0; i < n; i++){
            listaFinal.add(lista.get(i));
        }

        return listaFinal;
    }

    public static void main(String[] args) {
        NumPrim2 generador = new NumPrim2();
        ArrayList lista = generador.generarListaPrimos(20);

        System.out.println("Lista de primos hasta 20: " + lista);
    }
}
