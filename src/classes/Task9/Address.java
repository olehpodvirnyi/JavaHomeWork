package classes.Task9;

public class Address {
    private final String country;
    private final String region;
    private final String city;
    private final String street;
    private final int houseNumber;

    Address(String country, String region, String city, String street, int houseNumber) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return this.country;
    }

    public String getRegion() {
        return this.region;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public int getHouseNumber() {
        return this.houseNumber;
    }

    public String display() {
        return getCountry() + ", " + getRegion() + ", " + getCity() + ", " + getStreet() + ", " + getHouseNumber()
                + ".";
    }
}
