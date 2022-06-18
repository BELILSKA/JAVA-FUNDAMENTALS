package ObjectsAndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine = new Engine(model, power);

            if (input.length == 3) {
                if (isNum(input[2])) {
                engine.displacement = input[2];
                }else {
                    engine.efficiency = input[2];
                }
            }
            if (input.length == 4) {
                engine.displacement = input[2];
                engine.efficiency = input[3];
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engine = input[1];

            Engine currentEngine = engines.stream().filter(x -> x.getModel().equals(engine))
                    .findFirst().get();
            Car car = new Car(model,currentEngine);

            if (input.length == 3) {
                if (isNum(input[2])) {
                car.weight = input[2];
                }else {
                    car.color = input[2];
                }
            }else if (input.length == 4) {
                car.weight = input[2];
                car.color = input[3];
            }
            cars.add(car);
        }
        for (Car car : cars){
            System.out.println(car.toString());
        }
    }

    public static class Car {
        private String model;
        private Engine engine;
        private String weight;
        private String color;

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
            this.weight = "n/a";
            this.color = "n/a";
        }

        public Engine getEngine() {
            return engine;
        }

        @Override
        public String toString() {
            Engine engine = this.getEngine();
            return String.format("%s:%n%s%n  Weight: %s%n  Color: %s",
                    model, engine.toString(), weight, color);
        }

    }

    public static class Engine {
        private String model;
        private int power;
        private String displacement;
        private String efficiency;

        public Engine(String model, int power) {
            this.model = model;
            this.power = power;
            this.displacement = "n/a";
            this.efficiency = "n/a";
        }

        public String getModel() {
            return model;
        }

        @Override
        public String toString() {
            return String.format("  %s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s",
                    model,power,displacement,efficiency);
        }
    }

    private static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
