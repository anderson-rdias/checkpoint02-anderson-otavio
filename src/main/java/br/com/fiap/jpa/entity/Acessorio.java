package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio")
@SequenceGenerator(name = "acessorio", sequenceName = "SQ_TB_ACESSORIO", allocationSize = 1)
public class Acessorio implements Serializable{

	private static final long serialVersionUID = 6686964595458793400L;
	
	public Acessorio() {
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
	
	@ManyToMany(mappedBy = "acessoriosCarros")
	List<Carro> carros;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nDescrição: " + this.getDescricao()
			+"\nCarro: " + this.getCarros();
	}
	
	
}
