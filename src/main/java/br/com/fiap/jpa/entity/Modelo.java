package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_modelo")
@SequenceGenerator(name = "modelo", sequenceName = "SQ_TB_MODELO", allocationSize = 1)
public class Modelo implements Serializable{
	
	public Modelo() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }
	
	public Modelo(String descricao) {
		this();
		this.descricao = descricao;
	}

	private static final long serialVersionUID = 3504016512416571570L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modelo")
	private Long id;
	
	@Column(name = "ds_modelo", length = 80, nullable = false)
	private String descricao;
	
	@Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;
	
    @OneToMany(mappedBy = "modelo", fetch = FetchType.EAGER)
    private Set<Carro> carros;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Set<Carro> getCarros() {
		return carros;
	}

	public void setCarros(Set<Carro> carros) {
		this.carros = carros;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return descricao;
	}

}
