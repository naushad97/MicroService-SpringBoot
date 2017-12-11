package com.cts.product.addon.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@ComponentScan(basePackages= {"com.cts.product.addon"})
public class AddonServicesController {

	@RequestMapping (value = "/weather", 
			method = {RequestMethod.GET},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getWeatherReport() {
		return "{24C}";
	}
	
}
