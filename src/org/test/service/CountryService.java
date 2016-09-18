package org.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.test.bean.Country;

public class CountryService {
	static HashMap<Integer, Country> countryIdMap = getCountryIdMap();

	public CountryService() {
		super();
		if (countryIdMap == null) {
			countryIdMap = new HashMap<Integer, Country>();
			Country indiaCountry = new Country(1, "India", 10000);
			Country chinaCountry = new Country(4, "China", 20000);
			Country nepalCountry = new Country(3, "Nepal", 8000);
			Country bhutanCountry = new Country(2, "Bhutan", 7000);

			countryIdMap.put(1, indiaCountry);
			countryIdMap.put(4, chinaCountry);
			countryIdMap.put(3, nepalCountry);
			countryIdMap.put(2, bhutanCountry);
		}

	}

	

	public static HashMap<Integer, Country> getCountryIdMap() {
		
		return countryIdMap;
	}



	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>(countryIdMap.values());
		return countries;
	}

	public Country addcountry(Country country) {
		country.setId(getMaxId()+1);
		countryIdMap.put(country.getId(), country);
		
		return country;
	}

	public Country getCountry(int id) {
		Country country=countryIdMap.get(id);
		return country;
	}

	public void removeCountry(int id) {
		countryIdMap.remove(id);
		System.out.println("removed");
		
	}

	public Country updateCountry(Country country) {
		if(country.getId()<=0){
		return null;
		}
		countryIdMap.put(country.getId(), country);
		return country;
	}
	public static int getMaxId(){
		int max=0;
		for(int id:countryIdMap.keySet()){
			max=id;
		}
		return max;
	}

}
