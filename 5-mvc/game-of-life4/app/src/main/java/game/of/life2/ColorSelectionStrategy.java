package game.of.life2;
import java.util.List;

public interface ColorSelectionStrategy {
    ColorBehaviour selectColor(List<Celda> vecinos);
}
