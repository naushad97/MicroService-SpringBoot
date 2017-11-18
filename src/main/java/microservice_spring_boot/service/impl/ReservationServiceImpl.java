package microservice_spring_boot.service.impl;

import org.springframework.stereotype.Component;

import microservice_spring_boot.bo.AIOutputContext;
import microservice_spring_boot.bo.ReservationFulfillment;
import microservice_spring_boot.mapper.CommonUtils;

@Component
public class ReservationServiceImpl implements ReservationService {

	public ReservationFulfillment createReservation() {

		long resNumber = CommonUtils.generateReservationId();
		ReservationFulfillment reservationFulfillment = new ReservationFulfillment();
		
		reservationFulfillment.setSpeech("Reservation created successfully. Your reservation Id is "+resNumber);
		reservationFulfillment.setDisplayText("Reservation #"+resNumber);
		
		final AIOutputContext aiOutputContext = new AIOutputContext();
		aiOutputContext.setName("CarBooking");
		reservationFulfillment.setContextOut(aiOutputContext);
		
		return reservationFulfillment;
	}
}
