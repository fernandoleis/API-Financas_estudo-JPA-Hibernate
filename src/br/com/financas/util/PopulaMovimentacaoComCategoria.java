package br.com.financas.util;

import br.com.financas.modelo.Categoria;
import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class PopulaMovimentacaoComCategoria {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negocios");

        Conta conta = new Conta();
        conta.setId(2);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Viagem a SP");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("100.0"));
        movimentacao.setCategorias(Arrays.asList(categoria1,categoria2));
        movimentacao.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DAY_OF_MONTH,1);

        movimentacao2.setData(amanha);
        movimentacao2.setDescricao("Viagem a RJ");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategorias(Arrays.asList(categoria1,categoria2));
        movimentacao2.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        em.persist(categoria1);
        em.persist(categoria2);
        em.persist(movimentacao);
        em.persist(movimentacao2 );

        em.getTransaction().commit();
        em.close();
    }
}
