package com.servicing.micronaut.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.servicing.micronaut.domain.BillingDAO;
import com.servicing.micronaut.dto.BillingDTO;
import com.servicing.micronaut.repository.BillingRepository;

import io.micronaut.http.HttpResponse;

@Singleton
public class BillingServiceImpl<T> implements BillingService{
	
		
	//@Inject
	BillingDTO billingDTO = new BillingDTO();
	
	@Inject
	BillingDAO billingEntity;
	
	@Inject
	BillingRepository<T> billingRepository;
	
	ModelMapper modelMapper = new ModelMapper();  ;
	
	
	@Override
	public BillingDTO getBillingData(String loanNumber) {
		billingEntity = billingRepository.findOne(loanNumber);  
		modelMapper.map(billingEntity, billingDTO);
		//SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("billingAmount", "billingInvoiceId");
		//creating filter using FilterProvider class
		//		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		//constructor of MappingJacksonValue class  that has bean as constructor argument
		//		MappingJacksonValue mapping = new MappingJacksonValue(billingDTO);
		//configuring filters
		//		mapping.setFilters(filters);
		
		return billingDTO;
	}
	
	
	@Override
	public HttpResponse<Object> saveBillingData(BillingDTO billingInfo) {
		modelMapper.map(billingInfo, billingEntity);
		return billingRepository.add(billingEntity);	
                
	}


	@Override
	public boolean deleteBillingInfo(String loanNumber) {	
		boolean result = billingRepository.delete(loanNumber);
		return result;		
	}


	@Override
	public List<BillingDAO> getAllBillingData() {
		return billingRepository.findAll();		
	}
	
}
