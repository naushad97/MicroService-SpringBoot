package com.cts.product.rental.service;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cts.product.rental.bo.Reservation;
import com.cts.product.rental.util.CommonUtils;

@Component
public class ReservationServiceImpl implements ReservationService {

	public Reservation createReservation() {
		long resNumber = CommonUtils.generateReservationId();
		Reservation reservation = new Reservation();
		reservation.setId(""+resNumber);
		reservation.setPickupPoint("STL");
		reservation.setDropPoint("STL");
		reservation.setPickupDateTime(new Date());
		reservation.setDropoffDateTime(new Date());
		return reservation;
	}
}
