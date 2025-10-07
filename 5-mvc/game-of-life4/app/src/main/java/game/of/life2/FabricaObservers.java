package game.of.life2;

public interface FabricaObservers {
    public Observer createObserver(String type, Tablero tablero);
}
