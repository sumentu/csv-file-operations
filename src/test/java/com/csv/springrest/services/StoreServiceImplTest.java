package com.csv.springrest.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.csv.springrest.dto.Store;

@ExtendWith(MockitoExtension.class)
class StoreServiceImplTest {
	
	CSVRecord record;

	@InjectMocks
	private StoreServiceImpl service;
	
        public StoreServiceImplTest() {
		record = mock(CSVRecord.class);
	}
	
	@Test
	void testGetStoreById() throws IOException {
		Store store = new Store();
		store.setStoreId("152eec4-7bed-4597-bf5a-e06fcede5f4f");
		store.setAddress("kormangala");
		store.setCity("Banglore");
		store.setPostcode("152eec4-7bed-4597-bf5a-e06fcede5f4f");
	
		assertEquals("152eec4-7bed-4597-bf5a-e06fcede5f4f",service.getStore(store.getStoreId()).getStoreId());
		
	}
	
	void testGetStoreByCity() throws IOException{
		Store store = new Store();
		store.setStoreId("152eec4-7bed-4597-bf5a-e06fcede5f4f");
		store.setAddress("kormangala");
		store.setCity("Banglore");
		store.setPostcode("152eec4-7bed-4597-bf5a-e06fcede5f4f");
		
		List<Store> list = new ArrayList<Store>();
		list.add(store);
		
		assertEquals("152eec4-7bed-4597-bf5a-e06fcede5f4f", service.getStore("city").getStoreId());
	}

}
