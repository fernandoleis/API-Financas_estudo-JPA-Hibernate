package br.com.financas.teste;

import br.com.financas.modelo.Conta;
import br.com.financas.modelo.Movimentacao;
import br.com.financas.modelo.TipoMovimentacao;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJPARelacionamento {
    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setAgencia("0102");
        conta.setBanco("Itau");
        conta.setNumero("0987654");
        conta.setTitular("Kingnaldo");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.0"));
        movimentacao.setConta(conta);

        em.persist(conta);
        em.persist(movimentacao);

        em.getTransaction().commit();
        em.close();
    }
}
