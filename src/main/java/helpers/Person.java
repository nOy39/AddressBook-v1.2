package helpers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private final StringProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty phone;
    private final StringProperty country;
    private final StringProperty city;
    private final StringProperty address;
    private final StringProperty indx;
    private final StringProperty email;




    public Person(String id, String firstname, String lastName, String phone, String countr, String city, String address, String indx, String mail) {
        this.id = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstname);
        this.lastName = new SimpleStringProperty(lastName);
        this.phone = new SimpleStringProperty(phone);
        this.country = new SimpleStringProperty(countr);
        this.city = new SimpleStringProperty(city);
        this.address = new SimpleStringProperty(address);
        this.indx = new SimpleStringProperty(indx);
        this.email = new SimpleStringProperty(mail);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String value) {
        firstName.set(value);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String value) {
        lastName.set(value);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String value) {
        phone.set(value);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String value) {
        country.set(value);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String value) {
        city.set(value);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String value) {
        address.set(value);
    }

    public String getIndx() {
        return indx.get();
    }

    public StringProperty indxProperty() {
        return indx;
    }

    public void setIndx(String value) {
        indx.set(value);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }
}
