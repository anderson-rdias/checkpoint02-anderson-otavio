package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio")
@SequenceGenerator(name = "acessorio", sequenceName = "SQ_TB_ACESSORIO", allocationSize = 1)
public class Acessorio implements Serializable{

	private static final long serialVersionUID = 6686964595458793400L;
	
	public Acessorio() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }
	
	public Acessorio(String descricao) {
		this();
		this.descricao = descricao;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
	private Long id;
	
	@Column(name = "ds_acessorio", length = 80, nullable = false)
	private String descricao;
	
	@Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;
    
//	@ManyToMany(mappedBy = "acessoriosCarros")
//	List<Carro> carros;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
//	public List<Carro> getCarros() {
//		return carros;
//	}
//
//	public void setCarros(List<Carro> carros) {
//		this.carros = carros;
//	}
	
	public Long getId() {
		return id;
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

	@Override
	public String toString() {
		return descricao;
	}
	
	
}
