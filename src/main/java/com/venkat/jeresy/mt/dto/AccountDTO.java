package com.venkat.jersey.mt.model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class AccountDTO {

    private  String id;
    private  String balance;

    public void setId(String id) {
		this.id = id;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	private AccountDTO(String id, String balance) {
        this.id = id;
        this.balance = balance;
    }

    public AccountDTO() {
		super();
	}

	public static AccountDTO from(Account account) {
        return new AccountDTO(account.getId(), String.valueOf(account.getBalance()));
    }

    public String getId() {
        return id;
    }

    public String getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id='" + id + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
