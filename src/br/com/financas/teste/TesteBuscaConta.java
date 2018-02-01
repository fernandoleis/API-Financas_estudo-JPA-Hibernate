package br.com.financas.teste;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteBuscaConta {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        Conta conta = em.find(Conta.class, 1);
        conta.setTitular("Fernando Leis");
        System.out.println("conta.getTitular() = " + conta.getTitular());
        em.getTransaction().commit();
        em.close();

        EntityManager em2 = new JPAUtil().getEntityManager();
        em2.getTransaction().begin();

//        conta.setTitular("Detached");
//        em2.persist(conta);
        conta.setTitular("Fernando M C Leis");
        em2.merge(conta);

        em2.getTransaction().commit();
        em2.close();


    }

}
