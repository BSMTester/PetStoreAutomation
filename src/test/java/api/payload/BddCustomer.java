package api.payload;

public class BddCustomer {
	
	String Id;
	String FirstName;
	String LastName;
	String Street;
	String City;
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
}
