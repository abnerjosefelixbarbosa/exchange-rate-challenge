package com.org.backendjava.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.backendjava.dto.CurrencyView;
import com.org.backendjava.dto.DataView;

@Service
public class APIService extends Thread {
	//https://docs.awesomeapi.com.br/api-de-moedas
	
	public List<DataView> provideHistoricalExchangeRate(String firstCurrency, String secondCurrency, String startDate, String endDate) {
		RestTemplate restTemplate = new RestTemplate();
		String.format("https://economia.awesomeapi.com.br/json/daily/%s-%s?start_date=%s&end_date=%s", firstCurrency, secondCurrency, startDate,
				endDate);
		final String URL = "";
		
		DataView object = restTemplate.getForObject(URL, DataView.class);
		//List<DataView> dataViews = new ArrayList<DataView>();
		
		return null;
	}
	
	public DataView provideLatestCurrencyRate(String firstCurrency, String secondCurrency) {
		RestTemplate restTemplate = new RestTemplate();
		final String URL = String.format("https://economia.awesomeapi.com.br/json/last/%s-%s", firstCurrency,
				secondCurrency);
		
		DataView object = restTemplate.getForObject(URL, DataView.class);
		System.out.println(object.getCurrencyView().getCode());
		
		return null;
	}
}