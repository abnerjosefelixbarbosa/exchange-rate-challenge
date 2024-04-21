package com.org.backendjava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.org.backendjava.dto.CurrencyView;
import com.org.backendjava.dto.DailyView;
import com.org.backendjava.exception.NotFoundException;

@Service
public class APIService extends Thread {
	// https://docs.awesomeapi.com.br/api-de-moedas

	public List<DailyView> provideHistoricalExchangeRate(String firstCurrency, String secondCurrency, Long numberDays) {
		RestTemplate restTemplate = new RestTemplate();
		List<DailyView> dailyViews = new ArrayList<DailyView>();

		try {
			final String URL = String.format("https://economia.awesomeapi.com.br/json/daily/%s-%s/%d", firstCurrency,
					secondCurrency, numberDays);
			DailyView[] objects = restTemplate.getForObject(URL, DailyView[].class);
			
			for (DailyView i : objects) {
				System.out.println(i);
			}

			//System.out.println(objects);


			// sleep(3000);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		// DataView object = restTemplate.getForObject(URL, DataView.class);
		// List<DataView> dataViews = new ArrayList<DataView>();

		return dailyViews;
	}

	public CurrencyView provideLatestCurrencyRate(String firstCurrency, String secondCurrency) {
		RestTemplate restTemplate = new RestTemplate();
		CurrencyView currencyView = new CurrencyView();
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
			if (e.getMessage().equals(
					"404 Not Found: \"{\"status\":404,\"code\":\"CoinNotExists\",\"message\":\"moeda nao encontrada USD-BR\"}\"")) {
				throw new NotFoundException("moeda nao encontrada");
			}
			throw new RuntimeException(e.getMessage());
		}

		return currencyView;
	}
}