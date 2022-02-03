package jason;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

public class Task28 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(of(
                new Car(2015, "Sedan", "Audi", 2.0, 7000),
                new Car(2021, "Universal", "Audi", 2.2, 6000),
                new Car(2000, "Hatchback", "Audi", 2.0, 5000),
                new Car(2002, "Hatchback", "Audi", 2.0, 4000),
                new Car(2014, "Hatchback", "BMW", 2.0, 22000),
                new Car(2017, "Hatchback", "BMW", 2.0, 2000),
                new Car(2006, "SUV", "BMW", 2.0, 8000),
                new Car(2017, "Hatchback", "Mercedes", 2.2, 9000),
                new Car(2020, "SUV", "Mercedes", 2.2, 17000),
                new Car(2013, "Minivan", "Mercedes", 2.0, 15000)));
        writeJson(cars);
        readJson();
    }

    private static void writeJson(List<Car> cars) {
        JSONArray carsList = new JSONArray();
        cars.stream().forEach(element -> {
            JSONObject carDetails = new JSONObject();
            carDetails.put("brand", element.getBrand());
            carDetails.put("bodyType", element.getBodyType());
            carDetails.put("year", element.getYear());
            carDetails.put("еngineСapacity", element.getЕngineСapacity());
            carDetails.put("price", element.getPrice());
            JSONObject carObject = new JSONObject();
            carObject.put("car", carDetails);
            carsList.add(carObject);
        });
        try (FileWriter file = new FileWriter("src\\main\\java\\jason\\jasonemployees.json")) {
            file.write(carsList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readJson() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src\\main\\java\\jason\\jasonemployees.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray carsList = (JSONArray) obj;
            carsList.forEach(car -> parseCarObject((JSONObject) car));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseCarObject(JSONObject car) {
        JSONObject employeeObject = (JSONObject) car.get("car");
        String brand = (String) employeeObject.get("brand");
        String bodyType = (String) employeeObject.get("bodyType");
        long year = (long) employeeObject.get("year");
        double еngineСapacity = (Double) employeeObject.get("еngineСapacity");
        long price = (long) employeeObject.get("price");
        Car tempCar = new Car((int) year, bodyType, brand, еngineСapacity, (int)price);
        tempCar.display();
    }

}