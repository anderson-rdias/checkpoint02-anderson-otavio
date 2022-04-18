package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.AcessorioCarro;

public class AcessorioCarroDAOImpl extends HibernateGenericDAO<AcessorioCarro, Long>{

    private static AcessorioCarroDAOImpl instance = null;

    public AcessorioCarroDAOImpl() {
        super(AcessorioCarro.class);
    }

    public static AcessorioCarroDAOImpl getInstance() {

        if (instance == null) {
            instance = new AcessorioCarroDAOImpl();
        }

        return instance;
    }
}
