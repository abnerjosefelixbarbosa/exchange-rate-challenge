package com.org.backendjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.backendjava.dto.CurrencyView;
import com.org.backendjava.dto.DailyView;

@Service
public class RateService {
	@Autowired
	private APIService apiService;
	
	public List<DailyView> provideHistoricalExchangeRate(String firstCurrency, String secondCurrency, Long numberDays) {
		return apiService.provideHistoricalExchangeRate(firstCurrency, secondCurrency, numberDays);
	}
	
	public CurrencyView provideLatestCurrencyRate(String firstCurrency, String secondCurrency) {
		return apiService.provideLatestCurrencyRate(firstCurrency, secondCurrency);
	}
}