package Banco;

public class tarafaAcessaBanco implements Runnable {

    private PoolDeConexao pool;
    private GerenciadorDeTransacao tx;
    public tarafaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
        this.pool = pool;
        this.tx = tx;
    }

    public void run(){
        synchronized (pool){
            System.out.println("peguei a chave do pool");
            pool.getConnection();

            synchronized (tx){
                System.out.println("começando a gerenciar a tx");
                tx.begin();
            }
        }
    }
}
