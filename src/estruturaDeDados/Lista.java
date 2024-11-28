package estruturaDeDados;

class Node {
    int valor;
    Node proximo;

    public Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

public class Lista {
    private Node inicio;
    private int tamanho;

    public Lista() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void insereInicio(int i) {
        Node novo = new Node(i);
        novo.proximo = inicio;
        inicio = novo;
        tamanho++;
    }

    public void insereFim(int i) {
        Node novo = new Node(i);
        if (inicio == null) {
            inicio = novo;
        } else {
            Node atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public boolean buscaElemento(int i) {
        Node atual = inicio;
        while (atual != null) {
            if (atual.valor == i) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public Object buscaIndice(int i) {
        if (i < 0 || i >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        Node atual = inicio;
        for (int pos = 0; pos < i; pos++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public void removeInicio() {
        if (inicio == null) {
            throw new IllegalStateException("Lista está vazia");
        }
        inicio = inicio.proximo;
        tamanho--;
    }

    public void removeFim() {
        if (inicio == null) {
            throw new IllegalStateException("Lista está vazia");
        }
        if (inicio.proximo == null) {
            inicio = null;
        } else {
            Node atual = inicio;
            while (atual.proximo.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = null;
        }
        tamanho--;
    }

    public void removeIndice(int i) {
        if (i < 0 || i >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        if (i == 0) {
            removeInicio();
        } else {
            Node atual = inicio;
            for (int pos = 0; pos < i - 1; pos++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
            tamanho--;
        }
    }

    public void insereElementoPosicao(int i, int j) {
        if (j < 0 || j > tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        if (j == 0) {
            insereInicio(i);
        } else {
            Node novo = new Node(i);
            Node atual = inicio;
            for (int pos = 0; pos < j - 1; pos++) {
                atual = atual.proximo;
            }
            novo.proximo = atual.proximo;
            atual.proximo = novo;
            tamanho++;
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}
