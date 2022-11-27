package com.bbva.mzic.batch;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

// POJO  Plain Old Java Object
public class Withdraw implements Serializable {
	private static final long serialVersionUID = 1L;

	private String clientNumber;
	private Double amount;
	private String operationDate;

	public String getClientNumber() {
		return clientNumber;
	}

	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((clientNumber == null) ? 0 : clientNumber.hashCode());
		result = prime * result + ((operationDate == null) ? 0 : operationDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Withdraw other = (Withdraw) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (clientNumber == null) {
			if (other.clientNumber != null)
				return false;
		} else if (!clientNumber.equals(other.clientNumber))
			return false;
		if (operationDate == null) {
			if (other.operationDate != null)
				return false;
		} else if (!operationDate.equals(other.operationDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Withdraw [clientNumber=" + clientNumber + ", amount=" + amount + ", operationDate=" + operationDate
				+ "]";
	}
}
