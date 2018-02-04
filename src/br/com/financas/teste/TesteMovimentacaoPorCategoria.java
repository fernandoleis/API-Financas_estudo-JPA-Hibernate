package br.com.financas.teste;

import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteMovimentacaoPorCategoria {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Categoria categoria = new Categoria();
        categoria.setId(1);

        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);

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
