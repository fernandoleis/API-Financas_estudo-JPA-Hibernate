package br.com.financas.teste;

import br.com.financas.modelo.Cliente;
import br.com.financas.modelo.Conta;
import br.com.financas.util.JPAUtil;

import javax.persistence.EntityManager;

public class TestaContaCliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Amanda");
        cliente.setEndereco("Rua Edmundo");
        cliente.setProfissao("Psicologa");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Teste");
        cliente2.setEndereco("Rua Teste");
        cliente2.setProfissao("Tester");

        Conta conta = new Conta();
        conta.setId(2);
        cliente.setConta(conta);
        cliente2.setConta(conta);


        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(cliente);
//        entityManager.persist(cliente2);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
