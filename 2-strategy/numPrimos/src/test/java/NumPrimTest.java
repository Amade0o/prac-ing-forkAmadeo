import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;


//VOY A TENER QUE USAR MOCK
public class NumPrimTest {
    //Testeamos numprim 
    @Test
    public void test1(){
        List<Integer> expected = new ArrayList<>();
        NumPrim np = new NumPrim();
        List<Integer> actual = np.generarListaPrimos(0);
        
        assertEquals(expected, actual);
    }

    //Testeamos numprim 
    @Test
    public void test2(){
        List<Integer> expected = Arrays.asList(2);
        NumPrim np = new NumPrim();
        List<Integer> actual = np.generarListaPrimos(1);
        
        assertEquals(expected, actual);
    }

    //Testeamos numprim 
    @Test
    public void test3(){
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11);
        NumPrim np = new NumPrim();
        List<Integer> actual = np.generarListaPrimos(5);
        
        assertEquals(expected, actual);
    }

    //TEST PARA NUMPRIM2
    @Test
    public void test4(){
        List<Integer> expected = new ArrayList<>();
        NumPrim2 np = new NumPrim2();
        List<Integer> actual = np.generarListaPrimos(0);

        assertEquals(expected, actual);
    }

    //Testeamos numprim 
    @Test
    public void test5(){
        List<Integer> expected = Arrays.asList(2);
        NumPrim2 np = new NumPrim2();
        List<Integer> actual = np.generarListaPrimos(1);
        
        assertEquals(expected, actual);
    }

    //Testeamos numprim 
    @Test
    public void test6(){
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11);
        NumPrim2 np = new NumPrim2();
        List<Integer> actual = np.generarListaPrimos(5);
        
        assertEquals(expected, actual);
    }

    //Test parametrizado, tres tests en uno
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5})
    public void tests7(int n) {
        NumPrim np = new NumPrim();
        List<Integer> actual = np.generarListaPrimos(n);

        List<Integer> expected;
        if (n == 0) {
            expected = Collections.emptyList();
        } else if (n == 1) {
            expected = Arrays.asList(2);
        } else { // n == 5
            expected = Arrays.asList(2, 3, 5, 7, 11);
        }

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5})
    public void tests8(int n) {
        // esperado
        List<Integer> expected;
        if (n == 0) {
            expected = Collections.emptyList();
        } else if (n == 1) {
            expected = Arrays.asList(2);
        } else { // n == 5
            expected = Arrays.asList(2, 3, 5, 7, 11);
        }

        // probamos con NumPrim
        NumPrim np1 = new NumPrim();
        assertEquals(expected, np1.generarListaPrimos(n));

        // probamos con NumPrim2
        NumPrim2 np2 = new NumPrim2();
        assertEquals(expected, np2.generarListaPrimos(n));
    }

    //Si le paso por parametro el 1 sera NumPrim y si le paso el 2 sera NumPrim2
    //Creo que no es lo mejor, deberia pasar por parametro la clase
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    public void tests9(int n) {
        if(n == 1){
            NumPrim np = new NumPrim();
            ArrayList<Integer> actual = np.generarListaPrimos(5);
            List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11);
            assertEquals(expected, actual);
        }else if(n == 2){
            NumPrim2 np2 = new NumPrim2();
            ArrayList<Integer> actual = np2.generarListaPrimos(5);
            List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11);
            assertEquals(expected, actual);
        }
    }

    //crei que asi era pero debo usar el contexto
    @ParameterizedTest
    @ValueSource(classes = {NumPrim.class, NumPrim2.class})
    public void test10(Class<Integer> clase) throws Exception{
        //El parametro es "clase" generica y el objeto es "Object" generico
        //LLamamos al constructor de forma generica
        Object np = clase.getDeclaredConstructor().newInstance();

        int n = 5;

        List<Integer> actual;
        //actual = np.generarListaPrimos(n);
        
        if (np instanceof NumPrim) {
            actual = ((NumPrim) np).generarListaPrimos(n);
        } else {
            actual = ((NumPrim2) np).generarListaPrimos(n);
        }

        // esperado
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11);
        assertEquals(expected, actual);
    }

    //MOCK
    @Test
    public void testGenerarLista_UsaEstrategiaMock() {
        //interfazComportamiento es lo que implementa numPrim y numprim2
        interfazComportamiento mockEstrategia = Mockito.mock(interfazComportamiento.class);
        
        //Config mock
        ArrayList<Integer> mockResultado = new ArrayList<>(Arrays.asList(2,3,5));
        when(mockEstrategia.generarListaPrimos(3)).thenReturn(mockResultado);

        //Inyectar mock en contexto
        Contexto contexto = new Contexto(mockEstrategia);
        ArrayList<Integer> resultado = contexto.generarLista(3);

        //Verificamos que el resultado sea el esperado
        assertEquals(mockResultado, resultado);

        //Verificamos que el mock fue llamado correctamente
        verify(mockEstrategia).generarListaPrimos(3);
    }
}

