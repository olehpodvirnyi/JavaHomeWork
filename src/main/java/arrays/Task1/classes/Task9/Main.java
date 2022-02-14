package arrays.Task1.classes.Task9;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        List<Dwelling> dwellings = createListDwelling();
        printHouseByCity(dwellings, "Lviv");
        Search(dwellings);
    }

    private static List<Dwelling> createListDwelling() {
        return List.of(
                new Dwelling(House.PENTHOUSE, new Address("Ukraine", "Dnipropetrovsk region", "Dnipropetrovsk",
                        "Krakivsʹka", 1), 450, 600, 60,
                        550),
                new Dwelling(House.PENTHOUSE, new Address("Ukraine", "Dnipropetrovsk region", "Dnipropetrovsk",
                        "Pidvalʹna", 12), 620, 260, 100,
                        800),
                new Dwelling(House.PENTHOUSE, new Address("Ukraine", "Lviv region", "Lviv", "Pekarsʹka",
                        36), 120, 450, 60, 250),
                new Dwelling(House.FLAT, new Address("Ukraine", "Dnipropetrovsk region", "Dnipropetrovsk",
                        "Zelena", 15), 150, 100, 50,
                        500),
                new Dwelling(House.FLAT, new Address("Ukraine", "Lviv region", "Lviv", "Henerala Chuprynky",
                        14), 200, 900, 20, 620),
                new Dwelling(House.FLAT, new Address("Ukraine", "Lviv region", "Lviv", "Bohdana Khmelʹnytsʹkoho",
                        10), 320, 1000, 10, 560),
                new Dwelling(House.MANSION, new Address("Ukraine", "Dnipropetrovsk region", "Dnipropetrovsk",
                        "Shevchenka", 22), 452, 350, 250,
                        300),
                new Dwelling(House.MANSION, new Address("Ukraine", "Lviv region", "Lviv", "Svobody",
                        14), 320, 400, 200, 600),
                new Dwelling(House.MANSION, new Address("Ukraine", "Lviv region", "Lviv", "Virmensʹka",
                        55), 124, 500, 110, 700)
        );
    }

    private static void printHouseByCity(List<Dwelling> dwellings, String city) {
        dwellings.stream()
                .filter(dwelling -> dwelling
                        .getAddress()
                        .getCity()
                        .equals(city))
                .forEach(Dwelling::display);
    }

    private static void Search(List<Dwelling> dwellings) {
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
        List<Dwelling> result = dwellings.stream()
                .filter(dwelling -> searchCountry.equals("0") || dwelling.getAddress().getCountry().equals(searchCountry)
                        && searchRegion.equals("0") || dwelling.getAddress().getRegion().equals(searchRegion)
                        && searchCity.equals("0") || dwelling.getAddress().getCity().equals(searchCity)
                        && searchStreet.equals("0") || dwelling.getAddress().getStreet().equals(searchStreet)
                        && searchDistanceToKindergarten == 0 || dwelling.getDistanceToKindergarten() <= searchDistanceToKindergarten
                        && searchDistanceToSchools == 0 || dwelling.getDistanceToSchools() <= searchDistanceToSchools
                        && searchDistanceToPlaygrounds == 0 || dwelling.getDistanceToPlaygrounds() <= searchDistanceToPlaygrounds
                        && searchRent == 0 || dwelling.getRent() <= searchRent)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            out.println("No apartments were found with the set parameters!!!");
        } else {
            result.forEach(Dwelling::display);
        }
    }

}