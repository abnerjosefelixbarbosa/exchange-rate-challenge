package com.org.backendjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.dto.DataView;
import com.org.backendjava.services.RateService;

@RestController
@RequestMapping("/api/rate")
public class RateController {
	@Autowired
	private RateService rateService;
	
	@GetMapping("/historical-exchange")
	public ResponseEntity<?> provideHistoricalExchangeRate() {
		rateService.provideHistoricalExchangeRate();
		return ResponseEntity.status(200).body(null);
	}
	
	@GetMapping("/latest-currency")
	public ResponseEntity<DataView> provideLatestCurrencyRate(@RequestParam String firstCurrency, @RequestParam String secondCurrency) {
		DataView response = rateService.provideLatestCurrencyRate(firstCurrency, secondCurrency);
		return ResponseEntity.status(200).body(response);
	}
}