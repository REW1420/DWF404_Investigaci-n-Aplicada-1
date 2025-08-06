package com.example.Mini_Banco.domain.model;

import java.math.BigDecimal;

public class Account {
    private Long id;
    private BigDecimal balance;

    public Account(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0)
            throw new IllegalArgumentException("Insufficient funds");
        this.balance = this.balance.subtract(amount);
    }
}