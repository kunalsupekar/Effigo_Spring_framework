package com.SpringBoot.Restful_web.Filter;

import java.awt.datatransfer.StringSelection;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public MappingJacksonValue filtering() {
		Somebean somebean = new Somebean("value1", "value2", "value3");
		//SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");

		return mappingFilter(somebean, "field1", "field2");
	}

	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {

		List<Somebean> list = Arrays.asList(new Somebean("kunal", "anant", "supekar"),
				new Somebean("Mansi", "ganesh", "supekar"));

		return mappingFilter(list, "field2");
	}

	private MappingJacksonValue mappingFilter(Object obj, String... fields) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(obj);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter("somebeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

}
