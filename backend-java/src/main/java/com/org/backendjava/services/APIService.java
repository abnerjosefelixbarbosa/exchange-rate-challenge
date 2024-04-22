package com.org.backendjava.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.org.backendjava.dto.CurrencyDailyView;
import com.org.backendjava.dto.CurrencyView;
import com.org.backendjava.dto.DailyView;
import com.org.backendjava.exception.NotFoundException;

@Service
public class APIService extends Thread {
	// https://docs.awesomeapi.com.br/api-de-moedas

	public Page<DailyView> provideHistoricalExchangeRate(String firstCurrency, String secondCurrency, Long numberDays,
			Pageable pageable) {
		Collection<DailyView> dailyViews = new ArrayList<DailyView>();
		DailyView dailyView = new DailyView();
		CurrencyView currencyView = new CurrencyView();
		CurrencyDailyView currencyDailyView = new CurrencyDailyView();
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			final String URL = String.format("https://economia.awesomeapi.com.br/json/daily/%s-%s/%d", firstCurrency,
					secondCurrency, numberDays);
			Object object = restTemplate.getForObject(URL, Object.class);
			JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(object));

			for (int i = 0; i < jsonNode.withArray("").size(); i++) {
				ObjectNode objectNode = (ObjectNode) jsonNode.get(i);

				if (i != 0) {
					currencyDailyView.setCurrencyDailyView(objectNode);
				}
				
				dailyView.setCurrencyDailyView(currencyDailyView);
				dailyViews.add(dailyView);
			}

			sleep(3000);
		} catch (Exception e) {
            String message = e.getMessage();
			
			if (message.contains("404")) {
				throw new NotFoundException("moeda nao encontrada");
			} else {
				throw new RuntimeException(e.getMessage());
			}
			
		}
		
		int start = (int) pageable.getOffset();
	    int end = Math.min((start + pageable.getPageSize()), dailyViews.size());
		List<DailyView> list = new ArrayList<DailyView>(dailyViews)
				.subList(start, end);
		return new PageImpl<DailyView>(list, pageable, list.size());
	}

	public CurrencyView provideLatestCurrencyRate(String firstCurrency, String secondCurrency) {
		CurrencyView currencyView = new CurrencyView();
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			final String URL = String.format("https://economia.awesomeapi.com.br/json/last/%s-%s", firstCurrency,
					secondCurrency);
			Object object = restTemplate.getForObject(URL, Object.class);
			JsonNode jsonNode = objectMapper.readTree(objectMapper.writeValueAsString(object));

			ObjectNode objectNode = (ObjectNode) jsonNode.get(String.format("%s%s", firstCurrency, secondCurrency));

			if (objectNode != null && objectNode.isObject()) {
				currencyView.setCurrencyView(objectNode);
			}

			sleep(3000);
		} catch (Exception e) {
			String message = e.getMessage();
			
			if (message.contains("404")) {
				throw new NotFoundException("moeda nao encontrada");
			} else {
				throw new RuntimeException(e.getMessage());
			}
		}

		return currencyView;
	}
}