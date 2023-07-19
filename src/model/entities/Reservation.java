package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checlOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checlOut) {

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checlOut = checlOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheclOut() {
		return checlOut;
	}

	public long duration() {
		long diff = checlOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return " Reservation dates for updates must  be future ";
		} else if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checlOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checlOut)
				+ ", " + duration() + " nigths ";
	}

}
