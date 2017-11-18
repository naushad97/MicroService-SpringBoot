package microservice_spring_boot.bo;

public class Reservation {

	private Long reservation_id;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(Long reservation_id) {
		this.reservation_id = reservation_id;
	}
}
