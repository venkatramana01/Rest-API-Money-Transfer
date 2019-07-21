package com.venkat.jersey.mt.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.venkat.jersey.mt.error.IllegalOperationException;
import com.venkat.jersey.mt.error.InsufficientBalanceException;

@XmlRootElement
public class Account {

	@XmlElement
    private String id;
	
	@XmlElement
    private BigDecimal balance;

    public Account() {
        this.id = UUID.randomUUID().toString();
        this.balance = BigDecimal.ZERO;
    }

    public Account(String balance) {
        this.id = UUID.randomUUID().toString();
        this.balance = new BigDecimal(balance);
    }

    public Account(String id, String balance) {
        this.id = id;
        this.balance = new BigDecimal(balance);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal credit(BigDecimal amount) {
        validate(amount);

        balance = balance.add(amount);
        return balance;
    }

    public BigDecimal debit(BigDecimal amount) {
        validate(amount);

        if (balance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Debit can't be performed due to lack of funds on the account.");
        }

        balance = balance.subtract(amount);
        return balance;
    }

    @JsonDeserialize(contentAs=BigDecimal.class)
    public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
    
    public void setId(String id) {
  		this.id = id;
  	}

	private void validate(BigDecimal amount) {
        if (Objects.isNull(amount) || BigDecimal.ZERO.compareTo(amount) > 0) {
            throw new IllegalOperationException("You can only issue positive amount.");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
