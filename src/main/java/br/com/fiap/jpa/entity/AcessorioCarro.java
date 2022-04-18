package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio_carro")
public class AcessorioCarro implements Serializable {

	private static final long serialVersionUID = -7221609995023927154L;

	public AcessorioCarro() {
        this.ativo = true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public AcessorioCarro(Carro carro, Acessorio acessorio) {
        this();
        this.carro = carro;
        this.acessorio = acessorio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
    private Long id;

    @Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "acessorio_id")
    private Acessorio acessorio;

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

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    @Override
    public String toString() {
        return "Carro: " + this.getCarro().getPlaca() + " | Acessório: " + this.getAcessorio().getDescricao();
    }
}
