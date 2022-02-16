package com.csv.springrest.services;

import java.util.List;

import com.csv.springrest.dto.Store;

public interface StoreService {

	public Store getStore(String storeId);

	public List<Store> fetchAllStores(String condition) throws Exception;
}
