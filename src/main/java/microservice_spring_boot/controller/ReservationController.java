package microservice_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice_spring_boot.bo.ReservationFulfillment;
import microservice_spring_boot.service.impl.ReservationServiceImpl;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication 
@ComponentScan("microservice_spring_boot")
@RequestMapping("/res")
public class ReservationController {
	
	@Autowired(required=true)
	ReservationServiceImpl reservationServiceImpl;
	
	@RequestMapping(value="/create", produces = MediaType.APPLICATION_JSON_VALUE)
	ReservationFulfillment createRes() {
		return reservationServiceImpl.createReservation();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReservationController.class, args);
	}
}
