package com.servicing.micronaut.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.bson.BsonDecimal128;

import io.micronaut.context.annotation.Prototype;
import io.micronaut.core.annotation.Introspected;
@Prototype 
@Introspected
public class BillingDAO {
	
	
	@NotBlank
	private String loanNumber;
	@NotBlank
	private String billingAmount;
	@NotBlank
	private String billingInvoiceId;
	@NotBlank
	private String customerName;
	@NotBlank
	private String paymentMethod;
	@NotBlank
	private String direction;
	@NotBlank
    private Double transactionAmount;
	@NotBlank
    private String accountNumber;
	@NotBlank
    private String ccy;
	@NotBlank
    private Date billDueDate;
	private String comment;

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

	public Date getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	


	

	

	

}
