package br.com.financas.teste;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteTodasAsMovimentacoesDasContas {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
        Query query = em.createQuery(jpql);

        List<Conta> resultList = query.getResultList();

        for (Conta conta : resultList) {
            System.out.println("conta.getTitular() = " + conta.getTitular());
            System.out.println("conta.getMovimentacoes() = " + conta.getMovimentacoes());
        }

        em.getTransaction().commit();
        em.close();
    }
}
