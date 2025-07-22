package car;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Car implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ownerName;
	private String make;
	private String model;
	private String vinNo;
	private String licenseNo;
	private int year;
	private LocalDateTime date;
	
	public Car(String ownerName, String make, String model, String vinNo, String licenseNo, int year) {
		this.setOwnerName(ownerName);
		this.make = make;
		this.model = model;
		this.vinNo = vinNo;
		this.licenseNo = licenseNo;
		this.year = year;
		this.date = LocalDateTime.now();
	}

	public String getMake() {return make;}

	public void setMake(String make) {this.make = make;}

	public String getModel() {return model;}

	public void setModel(String model) {this.model = model;}

	public String getVinNo() {return vinNo;}

	public void setVinNo(String vinNo) {this.vinNo = vinNo;}

	public String getLicenseNo() {return licenseNo;}

	public void setLicenseNo(String licenseNo) {this.licenseNo = licenseNo;}

	public int getYear() {return year;}

	public void setYear(int year) {this.year = year;}

	public String getOwnerName() {return ownerName;}

	public void setOwnerName(String ownerName) {this.ownerName = ownerName;}
	
	public LocalDateTime getDate() {return date;}

	public void setDate(LocalDateTime date) {this.date = date;}
}
