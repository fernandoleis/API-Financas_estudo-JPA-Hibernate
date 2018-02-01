package br.com.financas.teste;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteRemoveConta {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Conta conta = em.find(Conta.class, 1);
        em.remove(conta);
        em.getTransaction().commit();
        em.close();

    }

}
