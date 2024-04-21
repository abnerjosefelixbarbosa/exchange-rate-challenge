package com.org.backendjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.backendjava.dto.CurrencyView;
import com.org.backendjava.dto.DailyView;
import com.org.backendjava.services.RateService;

@RestController
@RequestMapping("/api/rate")
public class RateController {
	@Autowired
	private RateService rateService;

	@GetMapping("/historical-exchange")
	public ResponseEntity<List<DailyView>> provideHistoricalExchangeRate(@RequestParam String firstCurrency,
			@RequestParam String secondCurrency, @RequestParam Long numberDays) {
		List<DailyView> dailyViews = rateService.provideHistoricalExchangeRate(firstCurrency, secondCurrency, numberDays);
		return ResponseEntity.status(200).body(dailyViews);
	}

	@GetMapping("/latest-currency")
	public ResponseEntity<CurrencyView> provideLatestCurrencyRate(@RequestParam String firstCurrency,
			@RequestParam String secondCurrency) {
		CurrencyView currencyView = rateService.provideLatestCurrencyRate(firstCurrency, secondCurrency);
		return ResponseEntity.status(200).body(currencyView);
	}
}