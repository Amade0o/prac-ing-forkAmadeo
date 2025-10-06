import java.util.ArrayList;

public class Contexto {
    private interfazComportamiento estrategia;
    private interfazDisplay display;

    public Contexto(interfazComportamiento estrategia){
        this.estrategia = estrategia;
    }

    public void cambiarEstrategia(interfazComportamiento estrategia){
        this.estrategia = estrategia;
    }

    public ArrayList<Integer> generarLista(int n){
        ArrayList resultado = (ArrayList) this.estrategia.generarListaPrimos(n);
        return resultado;
    }

    public void cambiarDisplay(interfazDisplay display){
        this.display = display;
    }
}
