package model.entidades;

import model.excecao.DominioExcecao;

public class Conta {
	private Integer numero;
	private String nome;
	private Double balanco;
	private Double LimiteDeRetirada;
	
	public Conta(Integer numero, String nome, Double balanco, Double limiteDeRetirada) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.balanco = balanco;
		LimiteDeRetirada = limiteDeRetirada;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getBalanco() {
		return balanco;
	}

	public void setBalanco(Double balanco) {
		this.balanco = balanco;
	}

	public Double getLimiteDeRetirada() {
		return LimiteDeRetirada;
	}

	public void setLimiteDeRetirada(Double limiteDeRetirada) {
		LimiteDeRetirada = limiteDeRetirada;
	}
	
	public void deposito(Double montante) {
		 balanco += montante;
	}
	public void saque(Double montante) throws DominioExcecao {
		if(montante > LimiteDeRetirada) {
			throw new DominioExcecao("valor de saque excede, valor limite: ");
		}
		if(montante > balanco) {
			throw new DominioExcecao("não existe saldo.");
		}
		
		montante -= balanco;
	}
	
}
