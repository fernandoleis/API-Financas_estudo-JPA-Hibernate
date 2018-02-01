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
    }

}
