package br.com.financas.teste;

import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TesteConta {

    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setTitular("Fernando Leis");
        conta.setAgencia("001");
        conta.setBanco("Inter");
        conta.setNumero("123456");

        EntityManager entityManager = new JPAUtil().getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(conta);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
