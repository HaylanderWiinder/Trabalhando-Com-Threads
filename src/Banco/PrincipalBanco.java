package Banco;

public class PrincipalBanco {
    public static void main(String[] args) throws InterruptedException {


        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();

        new Thread(new tarafaAcessaBanco(pool, tx)).start();
        new Thread(new tarafaAcessaBancoProcedimento(pool, tx)).start();

    }
}
