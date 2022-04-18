package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.List;

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
	
	@OneToMany(mappedBy = "carro", fetch = FetchType.EAGER)
	private List<Carro> carros;

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
				+ "\nCarro: " + this.getCarros();
	}

}
