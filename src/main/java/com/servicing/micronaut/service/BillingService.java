package com.servicing.micronaut.service;

import java.util.List;

import javax.inject.Singleton;

import com.servicing.micronaut.domain.BillingDAO;
import com.servicing.micronaut.dto.BillingDTO;

import io.micronaut.http.HttpResponse;

@Singleton
public interface BillingService {

	public BillingDTO getBillingData(String customerName);
	
	public List<BillingDAO> getAllBillingData();

	public HttpResponse<Object> saveBillingData(BillingDTO billingInfo);
	
	public boolean deleteBillingInfo(String loanId);

}
