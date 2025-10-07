package game.of.life2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Nace {
    ColorSelectionStrategy strategy;
    Step step;
    public Nace(Step step){
        this.step = step;
    }
    public abstract Celda nace(Celda casilla, int numVecinos,List<Celda> listaVecinos);

    public ColorBehaviour calcColorMayoritario(List<Celda> listaVecinos){
        // Usamos la CLASE como clave, no la instancia
        Map<Class<? extends ColorBehaviour>, Integer> contador = new HashMap<>();
        Map<Class<? extends ColorBehaviour>, ColorBehaviour> instanciasColor = new HashMap<>();

        for(Celda vecino : listaVecinos){
            ColorBehaviour color = vecino.colorBehaviour;
            Class<? extends ColorBehaviour> tipoColor = color.getClass(); // Obtenemos la clase

            // Contamos usando la clase
            contador.put(tipoColor, contador.getOrDefault(tipoColor, 0) + 1);
            // Guardamos una instancia de ese color para poder devolverla luego
            instanciasColor.putIfAbsent(tipoColor, color);
        }

        Class<? extends ColorBehaviour> tipoMayoritario = null;
        int max = -1;

        for(Map.Entry<Class<? extends ColorBehaviour>, Integer> entry : contador.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                tipoMayoritario = entry.getKey();
            }
        }

        // Si la lista no estaba vacía, devolvemos la instancia guardada.
        // Si estaba vacía, devolvemos un color por defecto.
        return (tipoMayoritario != null) ? instanciasColor.get(tipoMayoritario) : new ColBehBasicOFF();
    }   
}
