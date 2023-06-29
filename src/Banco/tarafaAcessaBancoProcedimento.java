package Banco;

public class tarafaAcessaBancoProcedimento implements Runnable {

    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;
    public tarafaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;


        
    }

    @Override
    public void run() {
        synchronized (pool){
            System.out.println("peguei a chave pool");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("começando a tx ");
                tx.begin();
            }


        }

    }
}
