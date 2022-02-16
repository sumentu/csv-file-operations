package com.csv.springrest.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.catalina.mapper.Mapper;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



class StoreTest {

	String json = "{\"storeId\":\"102\",\"postcode\":\"7639\",\"city\":\"Banglore\",\"address\":\"kormangala\",\"opendate\":12012022}";
	
	ObjectMapper mapper = new ObjectMapper();
	@Test
	void SerilizationTest() throws JsonProcessingException, ParseException{
		Store store = new Store();
		store.setAddress("kormangala");
		store.setCity("Banglore");
		store.setOpendate(new SimpleDateFormat("dd-mm-yyyy").parse("12-01-2022"));
		store.setPostcode("7639");
		store.setStoreId("102");
		System.out.println(mapper.writeValueAsString(store));
		Store readValue = mapper.readValue(json, Store.class);
		assertEquals(json, mapper.writeValueAsString(readValue));
	}
	
	@Test
	public void deserializationTest() throws JsonMappingException, JsonProcessingException{
		Store readValue = mapper.readValue(json, Store.class);
		assertEquals(json, mapper.writeValueAsString(readValue));
	}

}
