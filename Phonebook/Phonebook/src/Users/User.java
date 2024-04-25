package Users;

public class User {
    private final String username;
    private String firstName = "";
    private String lastName = "";
    private String companyName = "";
    private String phoneNumber = "";
    private String email = "";
    private String website = "";
    private int addressUnit = -1;
    private int addressCivic = -1;
    private String addressStreet = "";
    private String addressCity = "";
    private String addressProvince = "";
    private String addressPostal = "";
    private int id = -1;
    public User(String username) {

        this.username = username;

    }
    public void print() {
        System.out.print("\n" + id + " | " + firstName + " | " + lastName + " | " + companyName + " | " + username + " | " + phoneNumber + " | " + email + " | " + website + " | " + addressUnit + " | " + addressCivic + " | " + addressStreet + " | " + addressCity + " | " + addressProvince + " | " + addressPostal);
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public int getAddressUnit() {
        return addressUnit;
    }
    public void setAddressUnit(int addressUnit) {
        this.addressUnit = addressUnit;
    }
    public int getAddressCivic() {
        return addressCivic;
    }
    public void setAddressCivic(int addressCivic) {
        this.addressCivic = addressCivic;
    }
    public String getAddressStreet() {
        return addressStreet;
    }
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }
    public String getAddressCity() {
        return addressCity;
    }
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
    public String getAddressProvince() {
        return addressProvince;
    }
    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }
    public String getAddressPostal() {
        return addressPostal;
    }
    public void setAddressPostal(String addressPostal) {
        this.addressPostal = addressPostal;
    }
    public String getUsername() {
        return this.username;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
}
