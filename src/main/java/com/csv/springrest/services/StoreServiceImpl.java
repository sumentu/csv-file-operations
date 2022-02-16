package com.csv.springrest.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import com.csv.springrest.dto.Store;

@Service
public class StoreServiceImpl implements StoreService{
String line = " ";


	@Override
	public Store getStore(String storeId) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/stores.csv"))) {
			while((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(",");
				System.out.println(data[0]);
				if(data[0].equals(storeId)) {
					Store store = new Store();
					store.setStoreId(data[0]);
					store.setPostcode(data[1]);
					store.setCity(data[2]);
					store.setAddress(data[3]);
					store.setOpendate(new SimpleDateFormat("dd/mm/yyy").parse(data[4]));
					return store;
				}
			}
		} catch (IOException | java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Store> fetchAllStores(String condition) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
		@SuppressWarnings("resource")
		CSVParser parser = new CSVParser(reader,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
		List<Store> list = new ArrayList<>();
		Iterable<CSVRecord> csvRecord = parser.getRecords();

		for (@SuppressWarnings("unused")
		CSVRecord csvRecordTwo : csvRecord) {
			Store store = new Store();
			store.setStoreId(csvRecordTwo.get("Store Id"));
			store.setPostcode(csvRecordTwo.get("Post Code"));
			store.setCity(csvRecordTwo.get("City"));
			store.setAddress(csvRecordTwo.get("Address"));
			store.setOpendate(new SimpleDateFormat("dd/MM/yyyy").parse(csvRecordTwo.get("opened Date")));
			list.add(store);
		}
		if (condition.equalsIgnoreCase("city")) {
			return list.stream().sorted(Comparator.comparing(Store::getCity)).collect(Collectors.toList());
		} else if (condition.equalsIgnoreCase("date")) {
			return list.stream().sorted(Comparator.comparing(Store::getOpendate))
					.collect(Collectors.toList());
		}

		return null;

	}
	

}
