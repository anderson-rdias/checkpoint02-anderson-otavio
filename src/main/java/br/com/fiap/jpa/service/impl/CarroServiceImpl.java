package br.com.fiap.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.jpa.dao.impl.AcessorioDAOImpl;
import br.com.fiap.jpa.dao.impl.CarroDAOImpl;
import br.com.fiap.jpa.dao.impl.ModeloDAOImpl;
import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.service.GenericService;

public class CarroServiceImpl extends GenericService<Carro, Long> {

	private static CarroServiceImpl instance = null;
	
	private CarroDAOImpl carroDAO;
	private AcessorioDAOImpl acessorioDAO;
	private ModeloDAOImpl modeloDAO;
	
	private CarroServiceImpl() {
		carroDAO = CarroDAOImpl.getInstance();
		acessorioDAO = AcessorioDAOImpl.getInstance();
		modeloDAO = ModeloDAOImpl.getInstance();
	}
	
	public static CarroServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		
		return instance;
	}
	
	@Override
	public void inserir(Carro carro) {
		try {
			carroDAO.salvar(carro, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	public void adicionarAcessorio(Long idCarro, Long idAcessorio) {
		try {
			Carro carro = obter(idCarro);
			Acessorio acessorio = acessorioDAO.obterPorId(idAcessorio, getEntityManager());
			
			List<Acessorio> acessorios = carro.getAcessoriosCarros();
			
			Boolean temAcessorio = false;
			
			if (acessorios == null) {
				acessorios = new ArrayList<Acessorio>();
			} else {
				for (Acessorio acessorioDB : acessorios) {
					if (acessorioDB.getId().equals(idAcessorio)) {
						temAcessorio = true;
						break;
					}
				}
			}
			
			if (!temAcessorio) {
				acessorios.add(acessorio);
				carro.setAcessoriosCarros(acessorios);
				carroDAO.atualizar(carro, getEntityManager());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}
	
	@Override
	public void atualizar(Carro carro) {
		try {
			carroDAO.atualizar(carro, getEntityManager());
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public void remover(Long id) {
		try {
			carroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}

	@Override
	public Carro obter(Long id) {
		Carro carro = null;
		
		try {
			carro = carroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return carro;
	}

	@Override
	public List<Carro> listar() {
		List<Carro> carros = null;
		
		try {
			carros = carroDAO.listar(getEntityManager());
		} catch (Exception e) {
		} finally {
			closeEntityManager();
		}
		
		return carros;
	}
}
