package classes;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Task9 {
    static class Address {
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

    abstract static class Dwelling {

        protected Address address;
        protected float distanceToKindergarten;
        protected float distanceToSchools;
        protected float distanceToPlaygrounds;
        protected float rent;

        Dwelling(Address address, float distanceToKindergarten, float distanceToSchools, float distanceToPlaygrounds,
                 float rent) {
            this.address = address;
            this.distanceToKindergarten = distanceToKindergarten;
            this.distanceToSchools = distanceToSchools;
            this.distanceToPlaygrounds = distanceToPlaygrounds;
            this.rent = rent;
        }

        public abstract String getAddress();

        public abstract String getDistanceToKindergarten();

        public abstract String getDistanceToSchools();

        public abstract String getDistanceToPlaygrounds();

        public abstract float getRent();

        public abstract void display();
    }


    static class Mansion extends Dwelling {
        Mansion(Address address, float distanceToKindergarten, float distanceToSchools, float distanceToPlaygrounds,
                float rent) {
            super(address, distanceToKindergarten, distanceToSchools, distanceToPlaygrounds, rent);
        }

        public String getAddress() {
            return "Address: " + this.address.display();
        }

        public String getDistanceToKindergarten() {
            return "Distance to Kindergarten:" + this.distanceToKindergarten;
        }

        public String getDistanceToSchools() {
            return "Distance to Schools:" + this.distanceToSchools;
        }

        public String getDistanceToPlaygrounds() {
            return "Distance to Playgrounds:" + this.distanceToPlaygrounds;
        }

        public float getRent() {
            return this.rent;
        }

        public void display() {
            out.println("~~~~~~~~~~~~~~Mansion~~~~~~~~~~~~~~");
            out.println(getAddress());
            out.println(getDistanceToKindergarten());
            out.println(getDistanceToSchools());
            out.println(getDistanceToPlaygrounds());
            out.println("Rent: " + getRent());

        }
    }

    static class Flat extends Dwelling {
        Flat(Address address, float distanceToKindergarten, float distanceToSchools, float distanceToPlaygrounds,
             float rent) {
            super(address, distanceToKindergarten, distanceToSchools, distanceToPlaygrounds, rent);
        }

        public String getAddress() {
            return "Address: " + this.address.display();
        }

        public String getDistanceToKindergarten() {
            return "Distance to Kindergarten:" + this.distanceToKindergarten;
        }

        public String getDistanceToSchools() {
            return "Distance to Schools:" + this.distanceToSchools;
        }

        public String getDistanceToPlaygrounds() {
            return "Distance to Playgrounds:" + this.distanceToPlaygrounds;
        }

        public float getRent() {
            return this.rent;
        }

        public void display() {
            out.println("~~~~~~~~~~~~~~Flat~~~~~~~~~~~~~~");
            out.println(getAddress());
            out.println(getDistanceToKindergarten());
            out.println(getDistanceToSchools());
            out.println(getDistanceToPlaygrounds());
            out.println("Rent: " + getRent());

        }
    }

    static class Penthouse extends Dwelling {
        Penthouse(Address address, float distanceToKindergarten, float distanceToSchools, float distanceToPlaygrounds,
                  float rent) {
            super(address, distanceToKindergarten, distanceToSchools, distanceToPlaygrounds, rent);
        }

        public String getAddress() {
            return "Address: " + this.address.display();
        }

        public String getDistanceToKindergarten() {
            return "Distance to Kindergarten:" + this.distanceToKindergarten;
        }

        public String getDistanceToSchools() {
            return "Distance to Schools:" + this.distanceToSchools;
        }

        public String getDistanceToPlaygrounds() {
            return "Distance to Playgrounds:" + this.distanceToPlaygrounds;
        }

        public float getRent() {
            return this.rent;
        }

        public void display() {
            out.println("~~~~~~~~~~~~~~Penthouse~~~~~~~~~~~~~~");
            out.println(getAddress());
            out.println(getDistanceToKindergarten());
            out.println(getDistanceToSchools());
            out.println(getDistanceToPlaygrounds());
            out.println("Rent: " + getRent());

        }
    }

    public static void Search(Dwelling[] dwellings) {
        Scanner console = new Scanner(System.in);
        out.println("\n\t~~~~~~~~~~~Search~~~~~~~~~~");
        out.println("If you want to skip the search parameter, enter 0.\nFor example: Enter country: 0");
        out.println("````Address````");
        out.print("Enter country: ");
        String searchCountry = console.nextLine();
        out.print("Enter region: ");
        String searchRegion = console.nextLine();
        out.print("Enter city: ");
        String searchCity = console.nextLine();
        out.print("Enter street: ");
        String searchStreet = console.nextLine();
        out.println("````Distance````");
        out.print("Enter MAX distance to Kindergarten: ");
        float searchDistanceToKindergarten = console.nextFloat();
        out.print("Enter MAX distance to Schools: ");
        float searchDistanceToSchools = console.nextFloat();
        out.print("Enter MAX distance to Playgrounds: ");
        float searchDistanceToPlaygrounds = console.nextFloat();
        out.println("````Distance````");
        out.print("Enter MAX rent: ");
        float searchRent = console.nextFloat();
        Arrays.stream(dwellings)
                .filter(dwelling -> searchCountry.equals("0") || dwelling.address.getCountry().equals(searchCountry))
                .filter(dwelling -> searchRegion.equals("0") || dwelling.address.getRegion().equals(searchRegion))
                .filter(dwelling -> searchCity.equals("0") || dwelling.address.getCity().equals(searchCity))
                .filter(dwelling -> searchStreet.equals("0") || dwelling.address.getStreet().equals(searchStreet))
                .filter(dwelling -> searchDistanceToKindergarten == 0 || dwelling.distanceToKindergarten <= searchDistanceToKindergarten)
                .filter(dwelling -> searchDistanceToSchools == 0 || dwelling.distanceToSchools <= searchDistanceToSchools)
                .filter(dwelling -> searchDistanceToPlaygrounds == 0 || dwelling.distanceToPlaygrounds <= searchDistanceToPlaygrounds)
                .filter(dwelling -> searchRent == 0 || dwelling.rent <= searchRent)
                .forEach(Dwelling::display);
    }

    public static void main(String[] args) {

        Dwelling[] dwellings = new Dwelling[]{
                new Flat(new Address("Ukraine", "Dnipropetrovsk region", "Dnipropetrovsk", "Zelena",
                        15), 150, 100, 50, 500),
                new Flat(new Address("Ukraine", "Lviv region", "Lviv", "Henerala Chuprynky",
                        14), 200, 900, 20, 620),
                new Flat(new Address("Ukraine", "Lviv region", "Lviv", "Bohdana Khmelʹnytsʹkoho",
                        10), 320, 1000, 10, 560),
                new Mansion(new Address("Ukraine", "Dnipropetrovsk region", "Dnipropetrovsk",
                        "Krakivsʹka", 1), 450, 600, 60,
                        550),
                new Mansion(new Address("Ukraine", "Dnipropetrovsk region", "Dnipropetrovsk",
                        "Pidvalʹna", 12), 620, 260, 100,
                        800),
                new Mansion(new Address("Ukraine", "Lviv region", "Lviv", "Pekarsʹka",
                        36), 120, 450, 60, 250),
                new Penthouse(new Address("Ukraine", "Dnipropetrovsk region", "Dnipropetrovsk",
                        "Shevchenka", 22), 452, 350, 250,
                        300),
                new Penthouse(new Address("Ukraine", "Lviv region", "Lviv", "Svobody",
                        14), 320, 400, 200, 600),
                new Penthouse(new Address("Ukraine", "Lviv region", "Lviv", "Virmensʹka",
                        55), 124, 500, 110, 700),
        };
        out.println("\tAvailable housing in Lviv:");
        Arrays.stream(dwellings).filter(dwelling -> dwelling.address.getCity().equals("Lviv")).forEach(Dwelling::display);

        Search(dwellings);
    }

}