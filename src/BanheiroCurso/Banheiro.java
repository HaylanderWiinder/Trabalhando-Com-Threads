package BanheiroCurso;

public class Banheiro {

    public boolean eSujo = true;

    public void fazNumero1() {
        // Obtém o nome da thread atual
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " Batendo na porta!");

        synchronized (this) {
            // O bloco sincronizado garante que apenas uma thread por vez execute o código dentro dele.

            System.out.println(nome + " entrou no banheiro");
            while (eSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " está fazendo algo demorado");

            try {
                // Espera por 15 segundos (simulando uma ação demorada)
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.eSujo=true;

            System.out.println(nome + " deu descarga");
            System.out.println(nome + " está lavando as mãos");
            System.out.println(nome + " saiu do banheiro");
        }

    }
    public void fazNumero2() {
        // Obtém o nome da thread atual
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " Batendo na porta!");

        synchronized (this) {
            // O bloco sincronizado garante que apenas uma thread por vez execute o código dentro dele.

            System.out.println(nome + " entrou no banheiro");
            while (eSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " está fazendo algo demorado");

            try {
                // Espera por 15 segundos (simulando uma ação demorada)
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.eSujo=true;

            System.out.println(nome + " deu descarga");
            System.out.println(nome + " está lavando as mãos");
            System.out.println(nome + " saiu do banheiro");
        }

    }

    public void limpa() {

        String nome = Thread.currentThread().getName();

        System.out.println(nome + " batendo na porta");

        synchronized (this) {

            System.out.println(nome + " entrando no banheiro");

            if (!this.eSujo) {
                System.out.println(nome + ", não está sujo, vou sair");
                return;
            }

            System.out.println(nome + " limpando o banheiro");
            this.eSujo = false;

            try {
                Thread.sleep(13000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.notifyAll();

            System.out.println(nome + " saindo do banheiro");
        }
    }

        private void esperaLaFora (String nome ){
            System.out.println(nome + " eca esse banheiro ta imundo!!! ");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
