package com.csv.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.csv.springrest.dto.Store;
import com.csv.springrest.dto.storeresponce.StoreResponce;
import com.csv.springrest.services.StoreService;



@RestController
public class StoreController {

	@Autowired
	private StoreService storeservices;


	//get single customer data
	@GetMapping("/fetchId/{storeId}")
	public ResponseEntity<StoreResponce> getStore(@PathVariable String storeId) {
		Store StoreById = storeservices.getStore(storeId);
		if(StoreById!=null) {
			StoreResponce storeResponce = new StoreResponce(false, "Successfully Fetched By Id", StoreById);
			return new ResponseEntity<StoreResponce>(storeResponce,HttpStatus.OK);	
		}else {
			StoreResponce storeResponce = new StoreResponce(true, "Please Provide Valid Id", StoreById);
			return new ResponseEntity<StoreResponce>(storeResponce,HttpStatus.NOT_FOUND);
		}
	}

	//get all customer data
	@GetMapping("/fetchall/{condition}")
	public ResponseEntity<StoreResponce> fetchAllStoreDetails(@PathVariable String condition) throws Exception {
		List<Store> fetchByCity = storeservices.fetchAllStores(condition);
		if (!fetchByCity.isEmpty()) {
			StoreResponce storeResponce = new StoreResponce(false, "Successfully Fetch all Datas ", fetchByCity);
			return new ResponseEntity<StoreResponce>(storeResponce, HttpStatus.OK);
		}
			else {
				StoreResponce storeResponce = new StoreResponce(true, "Something Went Wrong !!! ", fetchByCity);
				return new ResponseEntity<StoreResponce>(storeResponce, HttpStatus.NOT_FOUND);
			}
		}
	}

