package br.com.rasmoo.restaurante.service.teste;

import br.com.rasmoo.restaurante.dao.PratoDao;
import br.com.rasmoo.restaurante.entity.Prato;
import br.com.rasmoo.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {

        Prato risoto = new Prato();
        risoto.setNome("Risoto de fruto do mar");
        risoto.setDescricao("Risoto acompanhando de lula polvo e marisco");
        risoto.setDiponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));


        Prato salmao = new Prato();
        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setDescricao("Salmão grelhado ao molho de maracuja");
        salmao.setDiponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));


        //Vai criar u entityManager que vai gerencia a entidade
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        PratoDao pratoDao =new PratoDao(entityManager);

        //iniciar a transição
        entityManager.getTransaction().begin();

        //cadastrar a transição
        pratoDao.cadatrar(risoto);
        entityManager.flush();
        pratoDao.cadatrar(salmao);
        entityManager.flush();
        //sincronizar o banco de dados
        //entityManager.getTransaction().commit();

        //fechar o banco
        //entityManager.close();



        System.out.println("O prato consultado foi : " + pratoDao.consultar(2));
        pratoDao.excluir(salmao);
        System.out.println("O prato consultado foi : " + pratoDao.consultar(2));
        System.out.println("O prato consultado foi : " + pratoDao.consultar(1));
        entityManager.clear();
        risoto.setValor(BigDecimal.valueOf(79.99));
        pratoDao.atualizar(risoto);
        System.out.println("O prato consultado foi : " + pratoDao.consultar(1));

    }
}
