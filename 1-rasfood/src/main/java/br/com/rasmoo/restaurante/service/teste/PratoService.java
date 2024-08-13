package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.entity.Prato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        Prato risoto = new Prato();
        risoto.setNome("Risoto de fruto do mar");
        risoto.setDescricao("Risoto acompanhando de lula polvo e marisco");
        risoto.setDiponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rasFood");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //iniciar a transição
        entityManager.getTransaction().begin();

        //fechar o transição
        entityManager.persist(risoto);

        //sincronizar o banco de dados
        entityManager.getTransaction().commit();

        //fechar o banco
        entityManager.clear();


    }
}
