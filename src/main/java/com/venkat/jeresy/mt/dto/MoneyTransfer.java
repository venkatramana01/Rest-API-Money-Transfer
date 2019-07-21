package com.venkat.jeresy.mt.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@XmlRootElement
final public class MoneyTransfer {

    private  String source;
    private  String target;
    private  BigDecimal amount;

    public void setSource(String source) {
		this.source = source;
	}

	public void setTarget(String target) {
		this.target = target;
	}
    @JsonDeserialize(contentAs=BigDecimal.class)
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public MoneyTransfer(String source, String target, String amount) {
        this.source = source;
        this.target = target;
        this.amount = new BigDecimal(amount);
    }

    public MoneyTransfer() {
        //default constructor added for jaxb compatibility
        source = "";
        target = "";
        amount = BigDecimal.ZERO;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "MoneyTransfer | amount=" + amount + " " +
                "from sourceAccount='" + source + '\'' +
                "to targetAccount='" + target;
    }
}
