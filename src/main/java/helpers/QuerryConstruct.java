package helpers;

public class QuerryConstruct {
    private String firstname, lastname, phone, country, city, address, indx, email;

    public QuerryConstruct() {
    }


    public QuerryConstruct(String firstname, String lastname, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public QuerryConstruct(String firstname, String lastname, String phone, String country, String city, String address, String indx, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.address = address;
        this.indx = indx;
        this.email = email;
    }
}
