package vo;

public class AccomVO {

	private int reservid;
	private String name, hotelname, hoteladdr, checkin, checkout;
	private String surname;
	
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getReservid() {
		return reservid;
	}
	public void setReservid(int reservid) {
		this.reservid = reservid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getHoteladdr() {
		return hoteladdr;
	}
	public void setHoteladdr(String hoteladdr) {
		this.hoteladdr = hoteladdr;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}	
	
}
