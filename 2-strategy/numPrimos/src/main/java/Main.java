import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        NumPrim numPrim = new NumPrim();
        NumPrim2 numPrim2 = new NumPrim2();
        Contexto contexto = new Contexto(numPrim);
        ArrayList<Integer> listaResultados;
        
        System.out.println("Resolviendo el problema con NumPrim1");
        listaResultados = contexto.generarLista(5);
        System.out.println(listaResultados);

        System.out.println("Cambiando de calculador...");
        contexto.cambiarEstrategia(numPrim2);

        System.out.println("Resolviendo el problema con NumPrim1");
        listaResultados = contexto.generarLista(5);
        System.out.println(listaResultados);
    }
}
