package br.com.financas.teste;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteJPQL {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Conta conta = new Conta();
        conta.setId(1);

        String jpql = "select m from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo order by m.valor desc ";
        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Movimentacao> movimentacoes = query.getResultList();
        for (Movimentacao movimentacoe : movimentacoes) {
            System.out.println("movimentacoe.getDescricao() = " + movimentacoe.getDescricao());
            System.out.println("movimentacoe.getConta().getId() = " + movimentacoe.getConta().getId());
            System.out.println("movimentacoe.getValor() = " + movimentacoe.getValor());
            System.out.println("movimentacoe.getConta().getTitular() = " + movimentacoe.getConta().getTitular());
        }



        em.getTransaction().commit();
        em.close();
    }
}
