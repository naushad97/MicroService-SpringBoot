package com.cts.product.rental.bo;

import java.util.Date;

public class Reservation {

	private String id;
	private String pickupPoint;
	private String dropPoint;
	private Date pickupDateTime;
	private Date dropoffDateTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}
	public Date getPickupDateTime() {
		return pickupDateTime;
	}
	public void setPickupDateTime(Date pickupDateTime) {
		this.pickupDateTime = pickupDateTime;
	}
	public Date getDropoffDateTime() {
		return dropoffDateTime;
	}
	public void setDropoffDateTime(Date dropoffDateTime) {
		this.dropoffDateTime = dropoffDateTime;
	}
	
}