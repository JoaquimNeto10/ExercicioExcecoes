package model.entities;

import model.exceptions.BusinessException;

public class Conta {
	
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	
	public Conta() {}
	
	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void depositar (double valor) {
		this.saldo += valor;
	}
	
	public void sacar (double valor) {
		validarSaque(valor);
		this.saldo -= valor;
	}

	private void validarSaque(double valor) {
		if(valor > getLimiteSaque()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque da conta!");
		} if(valor > getSaldo()) {
			throw new BusinessException("Erro de saque: A quantia excede o saldo da conta");
		}
		
	}
	
	
	

}
