package entities;

import exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	// Construtor padrão.
	public Account() {
	}

	// Construtor referenciando os atributos locais.
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	// Métodos Getters e Setters para manipulação dos atributos.
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	// Método para efetuar depósito.
	public void deposit(Double amount) {
		balance += amount;
	}	
	
	// Método para efetuar saque.
	public void withdraw(Double amount) {
		validatewithdrawLimit(amount);
		balance -= amount;
	}
	
	// Método para validar o limite de saque.
	public void validatewithdrawLimit(double amount) {
		if(amount > getWithdrawLimit()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque.");
		}
		if(amount > getBalance()) {
			throw new BusinessException("Erro de sague: Saldo é insuficiente");
		}
	}
}
