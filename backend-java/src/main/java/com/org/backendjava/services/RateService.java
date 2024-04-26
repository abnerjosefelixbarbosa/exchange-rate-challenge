package com.org.backendjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RateService {
	@Autowired
	private APIService apiService;

	public Page<Object> provideHistoricalExchangeRate(String firstCurrency, String secondCurrency, Long numberDays,
			Pageable pageable) {
		return apiService.provideHistoricalExchangeRate(firstCurrency, secondCurrency, numberDays, pageable);
	}

	public Object provideLatestCurrencyRate(String firstCurrency, String secondCurrency) {
		return apiService.provideLatestCurrencyRate(firstCurrency, secondCurrency);
	}
}