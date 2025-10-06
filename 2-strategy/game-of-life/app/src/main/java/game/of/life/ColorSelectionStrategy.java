package game.of.life;
import java.util.List;

public interface ColorSelectionStrategy {
    ColorBehaviour selectColor(List<Celda> vecinos);
}
