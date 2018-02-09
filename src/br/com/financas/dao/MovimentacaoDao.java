package br.com.financas.dao;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MovimentacaoDao {

    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
        String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo group by m.data";
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        return query.getResultList();
    }
}
