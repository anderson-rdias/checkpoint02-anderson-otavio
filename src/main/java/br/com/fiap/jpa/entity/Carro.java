package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
	
	public Carro() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }
	
	public Carro(String placa, String cor, String chassi, Modelo modelo) {
		this();
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
		this.modelo = modelo;
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
	
	@Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;
	
	@ManyToMany
	@JoinTable(
			name="tb_carro_acessorio",
			joinColumns = @JoinColumn(name = "acessorio_id"),
			inverseJoinColumns = @JoinColumn(name="carro_id"))
	private List<Acessorio> acessoriosCarros;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;
	

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
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Modelo: " + this.modelo + "\nPlaca: " + this.placa + "\nCor: " + this.cor
                + "\nChassi: " + this.chassi;
	}

}
