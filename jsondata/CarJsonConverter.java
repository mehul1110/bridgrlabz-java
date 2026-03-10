package jsondata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Car {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

public class CarJsonConverter {
    public static void main(String[] args) {
        Car myCar = new Car("Tesla", "Model S", 2023);

        // Convert Java Object to JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonFormat = gson.toJson(myCar);

        System.out.println("Java Object Converted to JSON:");
        System.out.println(jsonFormat);
    }
}
