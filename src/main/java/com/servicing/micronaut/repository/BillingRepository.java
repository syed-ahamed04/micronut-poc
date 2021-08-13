package com.servicing.micronaut.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.inject.Singleton;

import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.servicing.micronaut.domain.BillingDAO;

import io.micronaut.http.HttpResponse;

@Singleton
public class BillingRepository<T>  implements IRepository<T>{
    private final MongoClient mongoClient;
    
    public  BillingRepository(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
	public MongoCollection<BillingDAO> getCollection() {
		return mongoClient.getDatabase("Servicing").getCollection("Billing", BillingDAO.class);

	}

	@Override
	public List<BillingDAO> findAll() {
		final FindIterable<BillingDAO> iterable = getCollection().find();
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());

	}

	@Override
	public BillingDAO findOne(String loanNumber) {
		Bson filter = Filters.eq("loanNumber", loanNumber);
		BillingDAO billingEntity = getCollection().find(filter).first();  	
		return billingEntity;
	}


	@Override
	public HttpResponse<Object> add(BillingDAO billingEntity) {
		getCollection().insertOne(billingEntity);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("billingDetails", billingEntity);
		return HttpResponse.ok(responseMap);
	}

	@Override
	public boolean delete(String loanNumber) {
		DeleteResult result = getCollection().deleteOne(Filters.eq("loanNumber", loanNumber));
		if (result.getDeletedCount() == 1) {
			return true;
		} else {
			return false;
		}
	}

}