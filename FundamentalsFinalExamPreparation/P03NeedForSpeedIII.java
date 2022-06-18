package FundamentalsFinalExamPreparation;

import java.util.*;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\|");
            String carName = carData[0];
            int mileage = Integer.parseInt(carData[1]);
            int fuel = Integer.parseInt(carData[2]);

            Car car = new Car(carName, mileage, fuel);
            cars.put(carName, car);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commandLine = input.split(" : ");
            String command = commandLine[0];
            String car = commandLine[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(commandLine[2]);
                    int fuel = Integer.parseInt(commandLine[3]);

                    if (cars.get(car).getFuel() < fuel) {
                        System.out.println("Not enough fuel to make that ride");
                    }else {
                        cars.get(car).setMileage(cars.get(car).getMileage() + distance);
                        cars.get(car).setFuel(cars.get(car).getFuel() - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",car,distance,fuel);
                    }

                    if (cars.get(car).getMileage() > 100000) {
                        cars.remove(car);
                        System.out.printf("Time to sell the %s!%n",car);
                    }

                    break;
                case "Refuel":
                    int fuelToRefill = Integer.parseInt(commandLine[2]);

                    if (cars.get(car).getFuel() + fuelToRefill <= 75) {
                        cars.get(car).setFuel(cars.get(car).getFuel() + fuelToRefill);
                        System.out.printf("%s refueled with %d liters%n", car,fuelToRefill);
                    }else {
                       int fuelCanFitIn = 75 - cars.get(car).getFuel();
                        cars.get(car).setFuel(cars.get(car).getFuel() + fuelCanFitIn);
                        System.out.printf("%s refueled with %d liters%n", car,fuelCanFitIn);

                    }

                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commandLine[2]);

                    cars.get(car).setMileage(cars.get(car).getMileage() - kilometers);

                    if (cars.get(car).getMileage() < 10000) {
                        cars.get(car).setMileage(10000);
                    }else {
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }



            input = scanner.nextLine();
        }

        //"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."

        cars.forEach((k,v)-> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",k,v.getMileage(),v.getFuel()));
    }
    static class Car {
        String car;
        int mileage;
        int fuel;

        public Car(String car, int mileage, int fuel) {
            this.car = car;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getCar() {
            return car;
        }

        public void setCar(String car) {
            this.car = car;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }


}
