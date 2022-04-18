package br.com.fiap.jpa.main;

import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Modelo;
import br.com.fiap.jpa.service.impl.AcessorioServiceImpl;
import br.com.fiap.jpa.service.impl.CarroServiceImpl;
import br.com.fiap.jpa.service.impl.ModeloServiceImpl;

public class App {
	
	public static void main(String[] args) {
		//Instanciando service para executar operações na entidade Aluno
		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
		
		//Inserindo um novo curso
		Modelo modelo = new Modelo("Fiat Uno");
		modeloService.inserir(modelo);
		
		//Criando 3 instâncias de Aluno
		Acessorio acessorio1 = new Acessorio("Ar condicionado");
		Acessorio acessorio2 = new Acessorio("GPS");
		
		//Inserindo no banco os alunos 1 e 2
		acessorioService.inserir(acessorio1);
		acessorioService.inserir(acessorio2);
		
		//Inserindo um Carro
		Carro carro = new Carro("ABC-123", "Preto", "ODSIADISO145");
		carroService.inserir(carro);
	}

}
