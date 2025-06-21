//---------------------------------
//assignment 3
//Written by Jiemin Liang 40262509
//----------------------------------


public class CellPhone implements Cloneable {
	/**
	 * Name and ID: Jiemin liang 40262509 
	 * COMP 249 Assignment 3 
	 * Due Date: Dec 2,2024
	 * 
	 * @param args
	 */
	// Attributes
	long serialNum;
	String brand;
	int year;
	double price;

	// constructors
	public CellPhone(long serialNum, String brand, double price, int year) {
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	public CellPhone(CellPhone c, long x) {
		serialNum = x;
		brand = new String(c.brand);
		year = c.year;
		price = c.price;
	}

	public CellPhone(CellPhone c) {
		brand = new String(c.brand);
		serialNum = c.serialNum;
		year = c.year;
		price = c.price;
	}

	// clone method
	public CellPhone clone(long x) throws CloneNotSupportedException {

		CellPhone temp = (CellPhone) super.clone();
		temp.serialNum = x;
		temp.brand = new String(this.brand);
		return temp;

	}

	// getter and setter
	public long getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	// equals method
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhone other = (CellPhone) obj;
		return brand.equals(other.brand) && price == other.price && year == other.year;
	}

	@Override
	// toString method
	public String toString() {
		return "[" + serialNum + ": " + brand + " " + price + "$ " + year + "]";
	}

}
