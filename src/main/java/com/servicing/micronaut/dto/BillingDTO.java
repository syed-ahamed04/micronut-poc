package com.servicing.micronaut.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;


@JsonFilter("BillingFilter") 
public class BillingDTO {

	
	private String loanNumber;
	
	private String billingAmount;
	
	private String billingInvoiceId;

	private String customerName;
	
	private String paymentMethod;

	private String direction;
	
	private Double transactionAmount;
	
	private String accountNumber;
	
	private String ccy;
	
	private String comment;
	
	private Date billDueDate;
	
	public BillingDTO() {
        super();
    }
	
	
	public BillingDTO(final String loanNumber, final String customerName, final String accountNumber) {
        super();

        this.loanNumber = loanNumber;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(String billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getBillingInvoiceId() {
		return billingInvoiceId;
	}

	public void setBillingInvoiceId(String billingInvoiceId) {
		this.billingInvoiceId = billingInvoiceId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "BillingDTO [loanNumber=" + loanNumber + ", billingAmount=" + billingAmount + ", billingInvoiceId="
				+ billingInvoiceId + ", customerName=" + customerName + "]";
	}

}
