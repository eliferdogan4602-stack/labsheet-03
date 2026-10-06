
package myproject03;

public class Car{

  
    String plateNumber;
    String model;
    double mileage;     
    double fuelLevel;   
    double tankCapacity; 

   
    public Car(String plateNumber, String model, double startingFuelLevel, double tankCapacity) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.mileage = 0.0;
        this.tankCapacity = tankCapacity;

        if (startingFuelLevel > tankCapacity) {
            this.fuelLevel = tankCapacity;
        } else {
            this.fuelLevel = startingFuelLevel;
        }
    }

    
    public void drive(double km) {
        System.out.println("Driving " + km + " km...");
        double requiredFuel = km / 10.0; 

        if (requiredFuel > fuelLevel) {
            System.out.println("Not enough fuel for this trip!");
        } else {
            mileage += km;
            fuelLevel -= requiredFuel;
        }
    }

  
    public void refuel(double amount) {
        System.out.println("Refueling " + amount + " liters...");

        if (fuelLevel + amount > tankCapacity) {
            fuelLevel = tankCapacity;
            System.out.println("Tank is full, extra fuel discarded.");
        } else {
            fuelLevel += amount;
        }
    }

    
    public void checkStatus() {
        System.out.println("Status: Mileage = " + mileage + " km, Fuel = " + fuelLevel + " liters.");

        
        if (fuelLevel < (0.10 * tankCapacity)) {
            System.out.println("Low fuel warning!");
        }
        System.out.println();
    }

   
    public static void main(String[] args) {
        
        Car myCar = new Car("46 ELF 123", "Toyota", 20.0, 50.0);

        
        myCar.checkStatus();

     
        myCar.drive(120);
        myCar.checkStatus();

        myCar.drive(50);
        myCar.checkStatus();

        myCar.drive(50);
        myCar.checkStatus();

        myCar.refuel(60);
        myCar.checkStatus();
    }
}
    
    
