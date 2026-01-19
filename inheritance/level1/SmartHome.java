/*
 * Single Inheritance - Sample Problem 2
 * Smart Home Devices
 * Demonstrates single inheritance with Device as superclass and Thermostat as subclass
 */

// Superclass
class Device {
    protected String deviceId;
    protected String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayDeviceInfo() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass
class Thermostat extends Device {
    private int temperatureSetting;

    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status); // Call superclass constructor
        this.temperatureSetting = temperatureSetting;
    }

    public void displayStatus() {
        System.out.println("--- Thermostat Status ---");
        displayDeviceInfo(); // Call superclass method
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        System.out.println("-------------------------");
    }

    public void setTemperature(int temp) {
        this.temperatureSetting = temp;
        System.out.println("Temperature updated to " + temp + "°C");
    }
}

public class SmartHome {
    public static void main(String[] args) {
        // Create smart devices
        Thermostat livingRoom = new Thermostat("TH001", "Active", 22);
        Thermostat bedroom = new Thermostat("TH002", "Standby", 20);

        // Display status
        livingRoom.displayStatus();
        bedroom.displayStatus();

        // Update temperature
        livingRoom.setTemperature(24);
        livingRoom.displayStatus();
    }
}
