package br.com.fiap.jpa.service.impl;

import br.com.fiap.jpa.dao.impl.AcessorioCarroDAOImpl;
import br.com.fiap.jpa.dao.impl.AcessorioDAOImpl;
import br.com.fiap.jpa.entity.AcessorioCarro;
import br.com.fiap.jpa.service.GenericService;

import java.util.List;

public class AcessorioCarroServiceImpl extends GenericService<AcessorioCarro, Long> {

    private static AcessorioCarroServiceImpl instance = null;

    private AcessorioCarroDAOImpl acessorioCarroDAO;

    private AcessorioCarroServiceImpl() {
        acessorioCarroDAO = AcessorioCarroDAOImpl.getInstance();
    }

    public static AcessorioCarroServiceImpl getInstance() {

        if (instance == null) {
            instance = new AcessorioCarroServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(AcessorioCarro instance) {
        try {
            acessorioCarroDAO.salvar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(AcessorioCarro instance) {
        try {
            acessorioCarroDAO.atualizar(instance, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            acessorioCarroDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public AcessorioCarro obter(Long id) {
        AcessorioCarro acessorioCarro = null;

        try {
            acessorioCarro = acessorioCarroDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

        return acessorioCarro;
    }

    @Override
    public List<AcessorioCarro> listar() {
        List<AcessorioCarro> acessorios = null;

        try {
            acessorios = acessorioCarroDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

        return acessorios;
    }
}
