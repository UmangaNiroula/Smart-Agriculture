package com.example.smartagriculture;

public class DataPoint {
    String Temperature, Date, Humidity, Moisture;

    public DataPoint()
    {}

    public DataPoint(String temperature, String date, String humidity, String moisture) {
        Temperature = temperature;
        Date = date;
        Humidity = humidity;
        Moisture = moisture;
    }

    public String getTemperature() {
        return Temperature;
    }

    public String getDate() {
        return Date;
    }

    public String getHumidity() {
        return Humidity;
    }

    public String getMoisture() {
        return Moisture;
    }
}
