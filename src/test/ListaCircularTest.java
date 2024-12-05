package test;

import estruturaDeDados.ListaCircular;

public class ListaCircularTest {
    public static void main(String[] args) {
        ListaCircular listaCircular = new ListaCircular();

        // Testando a inserção no início
        System.out.println("Inserindo elementos no início:");
        listaCircular.insereInicio(10);
        listaCircular.insereInicio(20);
        listaCircular.insereInicio(30); // Lista circular: 30 -> 20 -> 10 -> (volta para 30)
        exibirLista(listaCircular);

        // Testando a inserção no final
        System.out.println("Inserindo elementos no final:");
        listaCircular.insereFim(40);
        listaCircular.insereFim(50); // Lista circular: 30 -> 20 -> 10 -> 40 -> 50 -> (volta para 30)
        exibirLista(listaCircular);

        // Testando busca por elemento
        System.out.println("Buscando elemento 20:");
        System.out.println(listaCircular.buscaElemento(20) ? "Elemento encontrado!" : "Elemento não encontrado.");

        System.out.println("Buscando elemento 100:");
        System.out.println(listaCircular.buscaElemento(100) ? "Elemento encontrado!" : "Elemento não encontrado.");

        // Testando busca por índice
        System.out.println("Buscando elemento no índice 2:");
        System.out.println("Elemento encontrado: " + listaCircular.buscaIndice(2));

        System.out.println("Buscando elemento no índice 10:");
        System.out.println("Elemento encontrado: " + listaCircular.buscaIndice(10));

        // Testando remoção no início
        System.out.println("Removendo elemento no início:");
        listaCircular.removeInicio(); // Remove 30
        exibirLista(listaCircular);

        // Testando remoção no final
        System.out.println("Removendo elemento no final:");
        listaCircular.removeFim(); // Remove 50
        exibirLista(listaCircular);

        // Testando remoção por índice
        System.out.println("Removendo elemento no índice 1:");
        listaCircular.removeIndice(1); // Remove 10
        exibirLista(listaCircular);

        // Testando inserção em posição específica
        System.out.println("Inserindo elemento 25 na posição 1:");
        listaCircular.insereElementoPosicao(25, 1); // Lista circular: 20 -> 25 -> 40 -> (volta para 20)
        exibirLista(listaCircular);

        System.out.println("Inserindo elemento 5 na posição 0:");
        listaCircular.insereElementoPosicao(5, 0); // Lista circular: 5 -> 20 -> 25 -> 40 -> (volta para 5)
        exibirLista(listaCircular);

        System.out.println("Inserindo elemento 100 na última posição:");
        listaCircular.insereElementoPosicao(100, 4); // Lista circular: 5 -> 20 -> 25 -> 40 -> 100 -> (volta para 5)
        exibirLista(listaCircular);
    }

    // Método auxiliar para exibir os elementos da lista circular
    private static void exibirLista(ListaCircular listaCircular) {
        System.out.println("Elementos na lista circular:");
        for (int i = 0; i < 10; i++) { // Limita a exibição a 10 elementos para evitar loops infinitos
            Object elemento = listaCircular.buscaIndice(i);
            if (elemento != null) {
                System.out.print(elemento + " -> ");
            } else {
                break;
            }
        }
        System.out.println("(volta para o início)");
    }
}
