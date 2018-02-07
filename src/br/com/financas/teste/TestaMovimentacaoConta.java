package br.com.financas.teste;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestaMovimentacaoConta {
    public static void main(String[] args) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();

        Movimentacao movimentacao = entityManager.find(Movimentacao.class, 3);
        Conta conta = movimentacao.getConta();
        System.out.println("conta.getTitular() = " + conta.getTitular());

        int size = conta.getMovimentacoes().size();
        System.out.println("size = " + size);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
