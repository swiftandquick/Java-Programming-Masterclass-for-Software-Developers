package s7p96_Polymorphism_Challenge_Exercise_Answer;

class Car {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;


    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        wheels = 4;
        engine = true;
    }


    public int getCylinders() {
        return cylinders;
    }


    public String getName() {
        return name;
    }


    public String startEngine() {
        return "Car -> startEngine()";
    }


    public String accelerate() {
        return "Car -> accelerate()";
    }


    public String brake() {
        return "Car -> brake()";
    }

}



class Mitsubishi extends Car {

    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }


    @Override
    public String startEngine() {
        return "Mitsubishi -> startEngine()";
    }


    @Override
    public String accelerate() {
        return "Mitsubishi -> accelerate()";
    }


    @Override
    public String brake() {
        return "Mitsubishi -> brake()";
    }

}



class Ford extends Car {

    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }


    @Override
    public String startEngine() {
        return "Ford -> startEngine()";
    }


    @Override
    public String accelerate() {
        return "Ford -> accelerate()";
    }


    @Override
    public String brake() {
        return "Ford -> brake()";
    }

}



public class Main {

    /* This is an inner class, a class inside another class.  */
    static class Holden extends Car {
        public Holden(int cylinders, String name) {
            super(cylinders, name);
        }
        @Override
        public String startEngine() {
            return getClass().getSimpleName() + " -> startEngine()";
        }
        @Override
        public String accelerate() {
            return getClass().getSimpleName() + " -> accelerate()";
        }
        @Override
        public String brake() {
            return getClass().getSimpleName() + " -> brake()";
        }
    }


    public static void main(String[] args) {

        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRM 4WD");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(6, "Ford Falcon");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        /* Create an inline class (anonymous class) */
        Car ford2 = new Ford(6, "Ford Falcon") {
            @Override
            public String startEngine() {
                return "Ford -> startEngine()";
            }
            @Override
            public String accelerate() {
                return "Ford -> accelerate()";
            }
            @Override
            public String brake() {
                return "Ford -> brake()";
            }
        };
        /* Use ford2 to call methods from the anonymous class.  */
        System.out.println(ford2.startEngine());
        System.out.println(ford2.accelerate());
        System.out.println(ford2.brake());


        Holden holden = new Holden(6, "Holden Commodore");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());


    }

}
