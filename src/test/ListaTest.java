package test;

import estruturaDeDados.Lista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaTest {

    private Lista lista;

    @BeforeEach
    void setup() {
        lista = new Lista();
    }

    @Test
    void testInsereInicio() {
        lista.insereInicio(10);
        lista.insereInicio(20);
        lista.insereInicio(30); // Lista: 30 -> 20 -> 10

        assertEquals(30, lista.buscaIndice(0));
        assertEquals(20, lista.buscaIndice(1));
        assertEquals(10, lista.buscaIndice(2));
    }

    @Test
    void testInsereFim() {
        lista.insereFim(10);
        lista.insereFim(20);
        lista.insereFim(30); // Lista: 10 -> 20 -> 30

        assertEquals(10, lista.buscaIndice(0));
        assertEquals(20, lista.buscaIndice(1));
        assertEquals(30, lista.buscaIndice(2));
    }

    @Test
    void testBuscaElemento() {
        lista.insereFim(10);
        lista.insereFim(20);
        lista.insereFim(30);

        assertTrue(lista.buscaElemento(20));
        assertFalse(lista.buscaElemento(100));
    }

    @Test
    void testRemoveInicio() {
        lista.insereFim(10);
        lista.insereFim(20);
        lista.insereFim(30); // Lista: 10 -> 20 -> 30

        lista.removeInicio(); // Remove 10
        assertEquals(20, lista.buscaIndice(0));
        lista.removeInicio(); // Remove 20
        assertEquals(30, lista.buscaIndice(0));
    }

    @Test
    void testRemoveFim() {
        lista.insereFim(10);
        lista.insereFim(20);
        lista.insereFim(30); // Lista: 10 -> 20 -> 30

        lista.removeFim(); // Remove 30
        assertEquals(20, lista.buscaIndice(1));
        lista.removeFim(); // Remove 20
        assertEquals(10, lista.buscaIndice(0));
    }

    @Test
    void testInsereElementoPosicao() {
        lista.insereFim(10);
        lista.insereFim(30);

        lista.insereElementoPosicao(20, 1); // Lista: 10 -> 20 -> 30
        assertEquals(20, lista.buscaIndice(1));
    }
}
