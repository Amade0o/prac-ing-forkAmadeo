import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class JuegoTest{
    @Test
    public void testInicializacionFrame() {
        Frame frame = new Frame();
        assertEquals(frame.tiro1, -1);
        assertEquals(frame.tiro2, -1);
    }

    @Test
    public void testInicializacionJuego(){
        Juego juego = new Juego();
        Frame[] linea = juego.getLinea();
        assertEquals(linea.length, 10);
    }
}