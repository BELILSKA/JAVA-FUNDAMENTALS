package ObjectsAndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);

            List<Tire> tires = new ArrayList<>();

            Tire tire1 = new Tire(tire1Pressure,tire1Age);
            Tire tire2 = new Tire(tire2Pressure,tire2Age);
            Tire tire3 = new Tire(tire3Pressure,tire3Age);
            Tire tire4 = new Tire(tire4Pressure,tire4Age);
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            Car car = new Car(model,engine,cargo,tires);
            carList.add(car);
        }
        String input = scanner.nextLine();

            if (input.equals("fragile")) {
                for (Car car : carList) {
                    if (car.cargo.type.equals("fragile")) {
                        for (Tire tire : car.tires) {
                            if (tire.pressure < 1) {
                                System.out.println(car);
                                break;
                            }
                        }
                    }
                }

            }else {
                for (Car car : carList) {
                    if (car.cargo.type.equals("flamable") && car.engine.power > 250) {
                        System.out.println(car);
                    }
                }
            }

    }
    public static class Car {
        private String model;
        private Engine engine;
        private Cargo cargo;
        private List<Tire> tires;

        public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }

        @Override
        public String toString() {
            return model;
        }
    }
    public static class Engine {
        private int speed;
        private int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

    }
    public static class Cargo {
        private int weight;
        private String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

    }
    public static class Tire {
       private double pressure;
       private int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

    }
}
