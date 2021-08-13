package com.servicing.micronaut.repository;


import java.util.List;

import javax.inject.Singleton;

import com.mongodb.client.MongoCollection;
import com.servicing.micronaut.domain.BillingDAO;

import io.micronaut.http.HttpResponse;
import io.reactivex.Maybe;

@Singleton
public interface IRepository<T> {

	MongoCollection<BillingDAO> getCollection();
	
	List<BillingDAO> findAll();
	
	BillingDAO findOne(String productCode);
	
	HttpResponse<Object> add(BillingDAO billingEntity);
	
	boolean delete(String loanNumber);
	

}
