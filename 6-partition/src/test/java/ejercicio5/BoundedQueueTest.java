// 1. Importaciones necesarias de JUnit 5
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import testing.partition.practico.ejercicio5.BoundedQueue;

//ESTOS TESTS ESTAN MAL, NO SATISFACEN BASE CHOICE COVERAGE
class BoundedQueueTest {
    @Test
    void caracteristica1_b1(){
        int capacity = -1;
        assertThrows(IllegalArgumentException.class,
            () -> {
                new BoundedQueue(capacity); 
            },
            "El constructor debe lanzar IllegalArgumentException para capacidad < 0" 
        );
    }

    @Test 
    void caracteristica1_b2(){
        int capacity = 2;
        BoundedQueue bq = new BoundedQueue(capacity);
        assertTrue(bq.isEmpty());
    }

    @Test
    void caracteristica1_b3(){
        int capacity = 0;
        BoundedQueue bq = new BoundedQueue(capacity);
        assertTrue(bq.isFull());
    }

    @Test 
    void caracteristica2_b1(){
        int capacity = 5;
        BoundedQueue bq = new BoundedQueue(capacity);

        assertThrows(NullPointerException.class,
            ()->{
            bq.enQueue(null);
            },
            "Enqueue debe lanzar error si se trata de encolar un null"
        );
    }

    @Test 
    void caracterstica2_b2(){
        int capacity = 5;
        BoundedQueue bq = new BoundedQueue(capacity);

        bq.enQueue(5);

        assertTrue(!bq.isEmpty());

        Object num = bq.deQueue();
        assertTrue(num.equals(5));
    }   

    @Test 
    void caracteristica3_b1_b2(){
        int capacity = 2;
        BoundedQueue bq = new BoundedQueue(capacity);
    
        bq.enQueue(5);
        bq.enQueue(8);

        assertThrows(IllegalStateException.class,
            ()->{
            bq.enQueue(4);
            },
            "Enqueue debe lanzar error si se trata de encolar cuando está llena"
        );
    }

    @Test 
    void caracteristica4_b1_b2(){
        int capacity = 2;
        BoundedQueue bq = new BoundedQueue(capacity);
    
        bq.enQueue(5);
        bq.enQueue(8);

        Object retornado1 = bq.deQueue();
        assertTrue(retornado1.equals(5));
        Object retornado2 = bq.deQueue();
        assertTrue(retornado2.equals(8));



        assertThrows(IllegalStateException.class,
            ()->{
            bq.deQueue();
            },
            "Deberia lanzar IllegalStateException si desencolas en vacio"
        );
    }
}