package classes.Task9;

import static java.lang.System.out;

class Dwelling {
    private House house;
    private Address address;
    private float distanceToKindergarten;
    private float distanceToSchools;
    private float distanceToPlaygrounds;
    private float rent;

    Dwelling(House house, Address address, float distanceToKindergarten, float distanceToSchools, float distanceToPlaygrounds,
             float rent) {
        this.house = house;
        this.address = address;
        this.distanceToKindergarten = distanceToKindergarten;
        this.distanceToSchools = distanceToSchools;
        this.distanceToPlaygrounds = distanceToPlaygrounds;
        this.rent = rent;
    }


    public Address getAddress() {
        return this.address;
    }

    public float getDistanceToKindergarten() {
        return this.distanceToKindergarten;
    }

    public float getDistanceToSchools() {
        return this.distanceToSchools;
    }

    public float getDistanceToPlaygrounds() {
        return this.distanceToPlaygrounds;
    }

    public float getRent() {
        return this.rent;
    }

    public void display() {
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        out.println(getAddress().display());
        out.println("Distance to Kindergarten:" + getDistanceToKindergarten());
        out.println("Type of house: " + getHouse());
        out.println("Distance to Schools:" + getDistanceToSchools());
        out.println("Distance to Playgrounds:" + getDistanceToPlaygrounds());
        out.println("Rent: " + getRent());
    }

    public House getHouse() {
        return house;
    }

}