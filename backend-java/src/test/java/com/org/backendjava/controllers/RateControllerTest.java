package com.org.backendjava.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ActiveProfiles
@AutoConfigureMockMvc
public class RateControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldProvideHistoricalExchangeRateAndReturn200Status() throws Exception {
		mockMvc.perform(get("/api/rate/historical-exchange?firstCurrency=USD&secondCurrency=BRL&numberDays=10"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
	@Test
	public void shouldProvideLatestCurrencyRateAndReturn200Status() throws Exception {
		mockMvc.perform(get("/api/rate/latest-currency?firstCurrency=USD&secondCurrency=BRL"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
}
