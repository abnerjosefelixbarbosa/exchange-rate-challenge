package com.org.backendjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.services.RateService;

@RestController
@RequestMapping("/api/rate")
public class RateController {
	@Autowired
	private RateService rateService;

	@GetMapping("/historical-exchange")
	public ResponseEntity<Page<Object>> provideHistoricalExchangeRate(@RequestParam String firstCurrency,
			@RequestParam String secondCurrency, @RequestParam Long numberDays, Pageable pageable) {
		Page<Object> dailyViews = rateService.provideHistoricalExchangeRate(firstCurrency, secondCurrency, numberDays, pageable);
		return ResponseEntity.status(200).body(dailyViews);
	}

	@GetMapping("/latest-currency")
	public ResponseEntity<Object> provideLatestCurrencyRate(@RequestParam String firstCurrency,
			@RequestParam String secondCurrency) {
		Object object = rateService.provideLatestCurrencyRate(firstCurrency, secondCurrency);
		return ResponseEntity.status(200).body(object);
	}
}