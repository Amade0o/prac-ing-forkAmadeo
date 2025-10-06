package game.of.life;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityColorStrategy implements ColorSelectionStrategy {
    
    @Override
    public ColorBehaviour selectColor(List<Celda> vecinos) {
        
        // Si no hay vecinos, retornamos un comportamiento por defecto.
        if (vecinos == null || vecinos.isEmpty()) {
            return new ColBehBasicOFF();
        }

        // Mapa para contar las apariciones de cada CARÁCTER (ej: '★' -> 3 veces)
        Map<Character, Integer> contador = new HashMap<>();
        
        // Mapa para guardar una instancia del objeto ColorBehaviour por cada CARÁCTER.
        // Nos servirá para devolver el objeto completo al final.
        Map<Character, ColorBehaviour> instanciaPorCaracter = new HashMap<>();

        // 1. Contamos los caracteres de los vecinos
        for (Celda vecino : vecinos) {
            ColorBehaviour colorBehaviour = vecino.colorBehaviour;
            char color = colorBehaviour.getColor(vecino);

            // Aumentamos el contador para este carácter específico
            int cuentaActual = contador.getOrDefault(color, 0);
            contador.put(color, cuentaActual + 1);

            // Guardamos el objeto que generó este carácter, si no lo teníamos ya.
            instanciaPorCaracter.putIfAbsent(color, colorBehaviour);
        }

        // 2. Encontramos el carácter con el conteo más alto
        char caracterMayoritario = ' '; // Un valor inicial por si acaso
        int conteoMaximo = -1;

        for (Map.Entry<Character, Integer> entrada : contador.entrySet()) {
            if (entrada.getValue() > conteoMaximo) {
                conteoMaximo = entrada.getValue();
                caracterMayoritario = entrada.getKey();
            }
        }

        // 3. Devolvemos el objeto ColorBehaviour asociado al carácter ganador
        return instanciaPorCaracter.get(caracterMayoritario);
    }
}

