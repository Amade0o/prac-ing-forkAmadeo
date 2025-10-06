package game.of.life;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class QuadColorSelection implements ColorSelectionStrategy{
        // 💡 Paso Clave: Definimos los 4 colores posibles de antemano.
    // Para que la lógica de "encontrar el cuarto" funcione, necesitamos saber
    // cuáles son los colores disponibles en este "universo de 4 colores".
    // (Asumiré que existen estas clases, puedes reemplazarlas por las tuyas).
    private static final List<ColorBehaviour> COLORES_DISPONIBLES = Arrays.asList(
        new ColInmig1(), 
        new ColInm2(), 
        new ColInm3(), 
        new ColInm4()
    );

    public QuadColorSelection() {
        // Constructor vacío
    }

    @Override
    public ColorBehaviour selectColor(List<Celda> vecinos) {
        if (vecinos == null || vecinos.size() != 3) {
            return new ColBehBasicOFF();
        }

        Set<ColorBehaviour> coloresVecinos = new HashSet<>();
        for(Celda vecino : vecinos) {
            coloresVecinos.add(vecino.colorBehaviour);
        }

        if (coloresVecinos.size() == 3) {
            return encontrarCuartoColor(coloresVecinos);
        } else {
            return encontrarColorMayoritario(vecinos);
        }
    }

    private ColorBehaviour encontrarCuartoColor(Set<ColorBehaviour> coloresDeVecinos) {
        // Creamos una copia de la lista de todos los colores disponibles.
        List<ColorBehaviour> coloresCandidatos = new ArrayList<>(COLORES_DISPONIBLES);
        
        // Eliminamos de nuestra lista de candidatos los colores que ya usan los vecinos.
        coloresCandidatos.removeAll(coloresDeVecinos);
        
        // El único color que queda en la lista es el "cuarto color".
        return coloresCandidatos.get(0);
    }

    private ColorBehaviour encontrarColorMayoritario(List<Celda> vecinos) {
        Map<ColorBehaviour, Integer> contador = new HashMap<>();

        for (Celda vecino : vecinos) {
            ColorBehaviour color = vecino.colorBehaviour;
            contador.put(color, contador.getOrDefault(color, 0) + 1);
        }

        ColorBehaviour colorMayoritario = null;
        int conteoMaximo = -1;

        for (Map.Entry<ColorBehaviour, Integer> entrada : contador.entrySet()) {
            if (entrada.getValue() > conteoMaximo) {
                conteoMaximo = entrada.getValue();
                colorMayoritario = entrada.getKey();
            }
        }
        return colorMayoritario;
    }
}
