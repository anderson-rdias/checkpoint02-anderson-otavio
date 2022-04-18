package br.com.fiap.jpa.main;

import br.com.fiap.jpa.entity.Acessorio;
import br.com.fiap.jpa.entity.AcessorioCarro;
import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.Modelo;
import br.com.fiap.jpa.service.impl.AcessorioCarroServiceImpl;
import br.com.fiap.jpa.service.impl.AcessorioServiceImpl;
import br.com.fiap.jpa.service.impl.CarroServiceImpl;
import br.com.fiap.jpa.service.impl.ModeloServiceImpl;

public class App {
	
	public static void main(String[] args) {
		//Instanciando service para executar operações na entidade Aluno
		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
		AcessorioCarroServiceImpl acessorioCarroService = AcessorioCarroServiceImpl.getInstance();
		
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
		Carro carro = new Carro("ABC-123", "Preto", "ODSIADISO145", modelo);
		carroService.inserir(carro);
		
		//Inserir com um acess�rio
		AcessorioCarro acessorioCarro1 = new AcessorioCarro(carro, acessorio1);
        AcessorioCarro acessorioCarro2 = new AcessorioCarro(carro, acessorio2);

        acessorioCarroService.inserir(acessorioCarro1);
        acessorioCarroService.inserir(acessorioCarro2);

        Carro listaCarros = carroService.obter(1L);

        acessorioCarroService.listar().forEach(System.out::println);
        System.out.println(listaCarros);
	}

}
