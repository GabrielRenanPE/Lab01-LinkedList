package test;

import estruturaDeDados.ListaCircular;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaCircularTest {

    private ListaCircular listaCircular;

    @BeforeEach
    void setup() {
        listaCircular = new ListaCircular();
    }

    @Test
    void testInsereInicio() {
        listaCircular.insereInicio(10);
        listaCircular.insereInicio(20);
        listaCircular.insereInicio(30); // Lista: 30 -> 20 -> 10 -> (volta para 30)

        assertEquals(30, listaCircular.buscaIndice(0));
        assertEquals(20, listaCircular.buscaIndice(1));
        assertEquals(10, listaCircular.buscaIndice(2));
    }

    @Test
    void testInsereFim() {
        listaCircular.insereFim(10);
        listaCircular.insereFim(20);
        listaCircular.insereFim(30); // Lista: 10 -> 20 -> 30 -> (volta para 10)

        assertEquals(10, listaCircular.buscaIndice(0));
        assertEquals(20, listaCircular.buscaIndice(1));
        assertEquals(30, listaCircular.buscaIndice(2));
    }

    @Test
    void testBuscaElemento() {
        listaCircular.insereFim(10);
        listaCircular.insereFim(20);
        listaCircular.insereFim(30);

        assertTrue(listaCircular.buscaElemento(20));
        assertFalse(listaCircular.buscaElemento(100));
    }

    @Test
    void testBuscaIndice() {
        listaCircular.insereFim(10);
        listaCircular.insereFim(20);
        listaCircular.insereFim(30);

        assertEquals(10, listaCircular.buscaIndice(0));
        assertEquals(20, listaCircular.buscaIndice(1));
        assertEquals(30, listaCircular.buscaIndice(2));
        assertNull(listaCircular.buscaIndice(3)); // Índice inválido
    }

    @Test
    void testRemoveInicio() {
        listaCircular.insereFim(10);
        listaCircular.insereFim(20);
        listaCircular.insereFim(30); // Lista: 10 -> 20 -> 30 -> (volta para 10)

        listaCircular.removeInicio(); // Remove 10
        assertEquals(20, listaCircular.buscaIndice(0));
        listaCircular.removeInicio(); // Remove 20
        assertEquals(30, listaCircular.buscaIndice(0));
    }

    @Test
    void testRemoveFim() {
        listaCircular.insereFim(10);
        listaCircular.insereFim(20);
        listaCircular.insereFim(30); // Lista: 10 -> 20 -> 30 -> (volta para 10)

        listaCircular.removeFim(); // Remove 30
        assertNull(listaCircular.buscaIndice(2));
        listaCircular.removeFim(); // Remove 20
        assertEquals(10, listaCircular.buscaIndice(0));
    }

    @Test
    void testRemoveIndice() {
        listaCircular.insereFim(10);
        listaCircular.insereFim(20);
        listaCircular.insereFim(30); // Lista: 10 -> 20 -> 30 -> (volta para 10)

        listaCircular.removeIndice(1); // Remove 20
        assertEquals(30, listaCircular.buscaIndice(1));
        listaCircular.removeIndice(0); // Remove 10
        assertEquals(30, listaCircular.buscaIndice(0));
    }

    @Test
    void testInsereElementoPosicao() {
        listaCircular.insereFim(10);
        listaCircular.insereFim(30);

        listaCircular.insereElementoPosicao(20, 1); // Lista: 10 -> 20 -> 30 -> (volta para 10)
        assertEquals(10, listaCircular.buscaIndice(0));
        assertEquals(20, listaCircular.buscaIndice(1));
        assertEquals(30, listaCircular.buscaIndice(2));

        listaCircular.insereElementoPosicao(5, 0); // Lista: 5 -> 10 -> 20 -> 30 -> (volta para 5)
        assertEquals(5, listaCircular.buscaIndice(0));
        assertEquals(10, listaCircular.buscaIndice(1));

        listaCircular.insereElementoPosicao(40, 4); // Lista: 5 -> 10 -> 20 -> 30 -> 40 -> (volta para 5)
        assertEquals(40, listaCircular.buscaIndice(4));
    }
}
