package game.of.life2;

public class ColInm2 implements ColorBehaviour {
    @Override
    public char getColor(Celda celda) {
        return '☯';
    }

    @Override
    public boolean equals(Object obj) {
        // Dos colores son iguales si pertenecen a la misma clase.
        // Ejemplo: un ColInm2 siempre será igual a otro ColInm2.
        if (obj == null) {
            return false;
        }
        return this.getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        // Genera un código único basado en el nombre de la clase.
        return this.getClass().hashCode();
    }
}
