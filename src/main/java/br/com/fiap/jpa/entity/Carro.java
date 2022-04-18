package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable{

	private static final long serialVersionUID = -7598498019702666377L;
	
	public Carro() {}
	
	public Carro(String placa, String cor, String chassi) {
		this();
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private Long id;
	
	@Column(name = "ds_placa", length = 7, nullable = false)
	private String placa;
	
	@Column(name = "nm_cor", length = 80, nullable = false)
	private String cor;
	
	@Column(name = "nm_chassi", length = 80, nullable = false)
	private String chassi;
	
	@ManyToMany
	@JoinTable(
			name="tb_carro_acessorio",
			joinColumns = @JoinColumn(name = "acessorio_id"),
			inverseJoinColumns = @JoinColumn(name="carro_id"))
	private List<Acessorio> acessoriosCarros;
	
	@ManyToOne
	private List<Acessorio> modeloCarro;
	

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public List<Acessorio> getAcessoriosCarros() {
		return acessoriosCarros;
	}

	public void setAcessoriosCarros(List<Acessorio> acessoriosCarros) {
		this.acessoriosCarros = acessoriosCarros;
	}
	
	public List<Acessorio> getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(List<Acessorio> modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	@Override
	public String toString() {
		return "\nPlaca: " + this.getPlaca()
				+ "\nCor: " + this.getCor()
				+ "\nChassi: " + this.getChassi()
				+ "\nAcessórios: " + this.getAcessoriosCarros()
				+ "\nModelo: " + this.getModeloCarro();
	}

}
