package com.csv.springrest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.csv.springrest.dto.Store;
import com.csv.springrest.dto.storeresponce.StoreResponce;
import com.csv.springrest.services.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
class StoreControllerTest {
	
	@MockBean
	private StoreService service;

	private MockMvc mockmvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@BeforeEach
	void setUp() throws Exception {
		mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void getStoreByIdtest() throws UnsupportedEncodingException, Exception{
		Date date = new SimpleDateFormat("dd-mm-yyyy").parse("12-01-2022");
		Store store = new Store();
		store.setStoreId("102");
		store.setAddress("kormangala");
		store.setCity("Banglore");
		store.setPostcode("7639");
		store.setOpendate(date);
		
		when(service.getStore(Mockito.anyString())).thenReturn(store);
		
		String contentAsString = mockmvc
				.perform(get("/fetchId/102").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(mapper.writeValueAsString(store)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		 StoreResponce readValue = mapper.readValue(contentAsString, StoreResponce.class);
		 assertEquals("Successfully Fetched By Id", readValue.getMsg());
	}
	
	@Test
	void getStoreByCityTest() throws UnsupportedEncodingException, Exception{
		List<Store> list = new ArrayList<>();
		Store store = new Store();
		store.setStoreId("102");
		store.setAddress("kormangala");
		store.setCity("Banglore");
		store.setPostcode("7639");
		list.add(store);
		
		when(service.fetchAllStores(Mockito.anyString())).thenReturn(list);
		
		String contentAsString = mockmvc
				.perform(get("/fetchall/city").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(mapper.writeValueAsString(store)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		StoreResponce readValue = mapper.readValue(contentAsString, StoreResponce.class);
		 assertEquals("Successfully Fetch all Datas ", readValue.getMsg());
	}

}
