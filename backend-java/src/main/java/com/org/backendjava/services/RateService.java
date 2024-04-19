package com.org.backendjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.dto.CurrencyView;
import com.org.backendjava.dto.DataView;

@Service
public class RateService {
	@Autowired
	private APIService apiService;
	
	public CurrencyView provideHistoricalExchangeRate() {
		return null;
	}
	
	public DataView provideLatestCurrencyRate(String firstCurrency, String secondCurrency) {
		return apiService.provideLatestCurrencyRate(firstCurrency, secondCurrency);
	}
}