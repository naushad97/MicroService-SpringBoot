package com.cts.product.rental.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.google.ai.bo.Fulfillment;
import com.cts.product.rental.google.ai.transformer.ReservationTransformer;
import com.cts.product.rental.service.ReservationService;

@RestController
@RequestMapping("/")
@ComponentScan(basePackages= {"com.cts.product.rental"})
public class ReservationController {
	private static final Logger LOG = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService; 
	@Autowired
	private ReservationTransformer transformer;
	
	@RequestMapping(
			value = "/lfs", 
			method = {RequestMethod.GET},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Fulfillment lowFareSearch() {
		
		return new Fulfillment();
	}

	@RequestMapping(
			value = "/create", 
			method = {RequestMethod.POST, RequestMethod.GET},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Fulfillment create() {
		LOG.debug("Entered into create reservation service");
		Reservation reservation = reservationService.createReservation();
		Fulfillment fullfillment = transformer.transform(reservation);
		LOG.debug("Exiting from create reservation service");
		return fullfillment;
	}
	
}
