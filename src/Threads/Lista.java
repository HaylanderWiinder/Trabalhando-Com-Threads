package Threads;

public class Lista {
    private String[] elementos = new String[1000];
    private int indice = 0;

    //atributos omitidos

    public synchronized void adicionaElementos(String elemento) {
        this.elementos[indice] = elemento;
        this.indice++;

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (this.indice == this.elementos.length){
            System.out.println(" lista esta cheia, notificando!!!" );
            this.notify();
        }

    }


    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }


    public boolean estaCheia() {
        return this.indice == this.tamanho();
    }
}